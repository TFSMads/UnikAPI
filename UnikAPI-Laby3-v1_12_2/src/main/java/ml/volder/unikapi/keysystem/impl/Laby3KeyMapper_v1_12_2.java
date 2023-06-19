package ml.volder.unikapi.keysystem.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.keysystem.Key;
import ml.volder.unikapi.keysystem.KeyMapper;
import ml.volder.unikapi.keysystem.MouseButton;
import org.lwjgl.input.Keyboard;

import java.util.HashMap;
import java.util.Map;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3KeyMapper_v1_12_2 extends KeyMapper {

    private static Laby3KeyMapper_v1_12_2 instance;

    public static Laby3KeyMapper_v1_12_2 getAPI() {
      if(instance == null)
        instance = new Laby3KeyMapper_v1_12_2();
      return instance;
    }

    @Override
    public String getNameByKey(Key key) {
        return key.getName();
    }

    @Override
    public int getIdByKey(Key key) {
        return key.getId();
    }

    @Override
    public int getIdByMouseButton(MouseButton mouseButton) {
        return mouseButton.getId();
    }

    @Override
    public Key getKeyById(int id) {
        for (Key key : this.keys.values()) {
            if (key.getId() == id)
                return key;
        }
        return null;
    }

    @Override
    public MouseButton getMouseButtonById(int i) {
        for (MouseButton mouseButton : this.mouseButtons.values()) {
            if (mouseButton.getId() == i)
                return mouseButton;
        }
        return null;
    }

    @Override
    public char getChar(Key key) {
        return key.getCharacter();
    }

    @Override
    public boolean isKeyPressed(Key key) {
        return Keyboard.isKeyDown(getLwjglKeyCode(key));
    }

    @Override
    public void initialize() {

    }

    @Override
    public void register(Key key, int i) {

    }


    private static final int DEFAULT_KEYCODE = -1;
    private static final Key DEFAULT_KEY = Key.NONE;
    private static Map<Integer, Key> lwjglKeyCodeMap;
    private static Map<Integer, MouseButton> lwjglMouseCodeMap;

    public static int getLwjglKeyCode(Key key) {
        if(lwjglKeyCodeMap == null)
            register();
        for(Map.Entry<Integer, Key> entry: lwjglKeyCodeMap.entrySet()){
            if(entry.getValue().equals(key))
                return entry.getKey();
        }
        return DEFAULT_KEYCODE;
    }

    public static Key getKeyByLwjglKeyCode(int keyCode) {
        if(lwjglKeyCodeMap == null)
            register();
        return lwjglKeyCodeMap.getOrDefault(keyCode, DEFAULT_KEY);
    }

    public static int getLwjglMouseButton(MouseButton mouseButton) {
        if(lwjglMouseCodeMap == null)
            register();
        for(Map.Entry<Integer, MouseButton> entry: lwjglMouseCodeMap.entrySet()){
            if(entry.getValue().equals(mouseButton))
                return entry.getKey();
        }
        return DEFAULT_KEYCODE;
    }

    public static MouseButton getMouseButtonByLwjglKeyCode(int keyCode) {
        if(lwjglMouseCodeMap == null)
            register();
        return lwjglMouseCodeMap.getOrDefault(keyCode, null);
    }

    static {
        if(lwjglKeyCodeMap == null || lwjglMouseCodeMap == null) {
            register();
        }
    }

    private static void register() {

        if(lwjglMouseCodeMap == null){
            MouseButton.initialize();
            if(MouseButton.LEFT == null) {
                //Can't register keys is not yet initialized
                return;
            }

            lwjglMouseCodeMap = new HashMap<>();

            lwjglMouseCodeMap.put(0 , (MouseButton) MouseButton.LEFT);
            lwjglMouseCodeMap.put(1 , (MouseButton) MouseButton.RIGHT);
            lwjglMouseCodeMap.put(2 , (MouseButton) MouseButton.MIDDLE);
            lwjglMouseCodeMap.put(3 , (MouseButton) MouseButton.M4);
            lwjglMouseCodeMap.put(4 , (MouseButton) MouseButton.M5);
            lwjglMouseCodeMap.put(5 , (MouseButton) MouseButton.M6);
            lwjglMouseCodeMap.put(6 , (MouseButton) MouseButton.M7);
            lwjglMouseCodeMap.put(7 , (MouseButton) MouseButton.M8);
        }

        if(lwjglKeyCodeMap == null) {
            Key.initialize();
            if(Key.NONE == null) {
                //Can't register keys is not yet initialized
                return;
            }

            lwjglKeyCodeMap = new HashMap<>();
            
            lwjglKeyCodeMap.put(0, Key.NONE);
            lwjglKeyCodeMap.put(1, Key.ESCAPE);
            lwjglKeyCodeMap.put(2, Key.NUM1);
            lwjglKeyCodeMap.put(3, Key.NUM2);
            lwjglKeyCodeMap.put(4, Key.NUM3);
            lwjglKeyCodeMap.put(5, Key.NUM4);
            lwjglKeyCodeMap.put(6, Key.NUM5);
            lwjglKeyCodeMap.put(7, Key.NUM6);
            lwjglKeyCodeMap.put(8, Key.NUM7);
            lwjglKeyCodeMap.put(9, Key.NUM8);
            lwjglKeyCodeMap.put(10, Key.NUM9);
            lwjglKeyCodeMap.put(11, Key.NUM0);
            lwjglKeyCodeMap.put(12, Key.MINUS);
            lwjglKeyCodeMap.put(13, Key.EQUAL);
            lwjglKeyCodeMap.put(14, Key.BACK);
            lwjglKeyCodeMap.put(15, Key.TAB);
            lwjglKeyCodeMap.put(16, Key.Q);
            lwjglKeyCodeMap.put(17, Key.W);
            lwjglKeyCodeMap.put(18, Key.E);
            lwjglKeyCodeMap.put(19, Key.R);
            lwjglKeyCodeMap.put(20, Key.T);
            lwjglKeyCodeMap.put(21, Key.Y);
            lwjglKeyCodeMap.put(22, Key.U);
            lwjglKeyCodeMap.put(23, Key.I);
            lwjglKeyCodeMap.put(24, Key.O);
            lwjglKeyCodeMap.put(25, Key.P);
            lwjglKeyCodeMap.put(26, Key.L_BRACKET);
            lwjglKeyCodeMap.put(27, Key.R_BRACKET);
            lwjglKeyCodeMap.put(28, Key.ENTER);
            lwjglKeyCodeMap.put(29, Key.L_CONTROL);
            lwjglKeyCodeMap.put(30, Key.A);
            lwjglKeyCodeMap.put(31, Key.S);
            lwjglKeyCodeMap.put(32, Key.D);
            lwjglKeyCodeMap.put(33, Key.F);
            lwjglKeyCodeMap.put(34, Key.G);
            lwjglKeyCodeMap.put(35, Key.H);
            lwjglKeyCodeMap.put(36, Key.J);
            lwjglKeyCodeMap.put(37, Key.K);
            lwjglKeyCodeMap.put(38, Key.L);
            lwjglKeyCodeMap.put(39, Key.SEMICOLON);
            lwjglKeyCodeMap.put(40, Key.APOSTROPHE);
            lwjglKeyCodeMap.put(41, Key.GRAVE);
            lwjglKeyCodeMap.put(42, Key.L_SHIFT);
            lwjglKeyCodeMap.put(43, Key.BACKSLASH);
            lwjglKeyCodeMap.put(44, Key.Z);
            lwjglKeyCodeMap.put(45, Key.X);
            lwjglKeyCodeMap.put(46, Key.C);
            lwjglKeyCodeMap.put(47, Key.V);
            lwjglKeyCodeMap.put(48, Key.B);
            lwjglKeyCodeMap.put(49, Key.N);
            lwjglKeyCodeMap.put(50, Key.M);
            lwjglKeyCodeMap.put(51, Key.COMMA);
            lwjglKeyCodeMap.put(52, Key.PERIOD);
            lwjglKeyCodeMap.put(53, Key.SLASH);
            lwjglKeyCodeMap.put(54, Key.R_SHIFT);
            lwjglKeyCodeMap.put(55, Key.MULTIPLY);
            lwjglKeyCodeMap.put(56, Key.L_ALT);
            lwjglKeyCodeMap.put(57, Key.SPACE);
            lwjglKeyCodeMap.put(58, Key.CAPS_LOCK);
            lwjglKeyCodeMap.put(59, Key.F1);
            lwjglKeyCodeMap.put(60, Key.F2);
            lwjglKeyCodeMap.put(61, Key.F3);
            lwjglKeyCodeMap.put(62, Key.F4);
            lwjglKeyCodeMap.put(63, Key.F5);
            lwjglKeyCodeMap.put(64, Key.F6);
            lwjglKeyCodeMap.put(65, Key.F7);
            lwjglKeyCodeMap.put(66, Key.F8);
            lwjglKeyCodeMap.put(67, Key.F9);
            lwjglKeyCodeMap.put(68, Key.F10);
            lwjglKeyCodeMap.put(69, Key.NUM_LOCK);
            lwjglKeyCodeMap.put(70, Key.SCROLL);
            lwjglKeyCodeMap.put(71, Key.NUMPAD7);
            lwjglKeyCodeMap.put(72, Key.NUMPAD8);
            lwjglKeyCodeMap.put(73, Key.NUMPAD9);
            lwjglKeyCodeMap.put(74, Key.SUBTRACT);
            lwjglKeyCodeMap.put(75, Key.NUMPAD4);
            lwjglKeyCodeMap.put(76, Key.NUMPAD5);
            lwjglKeyCodeMap.put(77, Key.NUMPAD6);
            lwjglKeyCodeMap.put(78, Key.ADD);
            lwjglKeyCodeMap.put(79, Key.NUMPAD1);
            lwjglKeyCodeMap.put(80, Key.NUMPAD2);
            lwjglKeyCodeMap.put(81, Key.NUMPAD3);
            lwjglKeyCodeMap.put(82, Key.NUMPAD0);
            lwjglKeyCodeMap.put(83, Key.DECIMAL);
            lwjglKeyCodeMap.put(87, Key.F11);
            lwjglKeyCodeMap.put(88, Key.F12);
            lwjglKeyCodeMap.put(100, Key.F13);
            lwjglKeyCodeMap.put(101, Key.F14);
            lwjglKeyCodeMap.put(102, Key.F15);
            lwjglKeyCodeMap.put(103, Key.F16);
            lwjglKeyCodeMap.put(104, Key.F17);
            lwjglKeyCodeMap.put(105, Key.F18);
            lwjglKeyCodeMap.put(113, Key.F19);
            lwjglKeyCodeMap.put(141, Key.NUMPAD_EQUAL);
            lwjglKeyCodeMap.put(156, Key.NUMPAD_ENTER);
            lwjglKeyCodeMap.put(157, Key.R_CONTROL);
            lwjglKeyCodeMap.put(167, Key.WORLD_1);
            lwjglKeyCodeMap.put(179, Key.COMMA);
            lwjglKeyCodeMap.put(181, Key.DIVIDE);
            lwjglKeyCodeMap.put(183, Key.PRINT);
            lwjglKeyCodeMap.put(184, Key.R_ALT);
            lwjglKeyCodeMap.put(197, Key.PAUSE);
            lwjglKeyCodeMap.put(199, Key.HOME);
            lwjglKeyCodeMap.put(200, Key.ARROW_UP);
            lwjglKeyCodeMap.put(201, Key.PAGE_UP);
            lwjglKeyCodeMap.put(203, Key.ARROW_LEFT);
            lwjglKeyCodeMap.put(205, Key.ARROW_RIGHT);
            lwjglKeyCodeMap.put(207, Key.END);
            lwjglKeyCodeMap.put(208, Key.ARROW_DOWN);
            lwjglKeyCodeMap.put(209, Key.PAGE_DOWN);
            lwjglKeyCodeMap.put(210, Key.INSERT);
            lwjglKeyCodeMap.put(211, Key.DELETE);
            lwjglKeyCodeMap.put(219, Key.L_WIN);
            lwjglKeyCodeMap.put(220, Key.R_WIN);
            lwjglKeyCodeMap.put(221, Key.MENU);
        }

        /*lwjglKeyCodeMap.put(Key.NONE, 0);
        lwjglKeyCodeMap.put(Key.ESCAPE, 1);
        lwjglKeyCodeMap.put(Key.NUM1, 2);
        lwjglKeyCodeMap.put(Key.NUM2, 3);
        lwjglKeyCodeMap.put(Key.NUM3, 4);
        lwjglKeyCodeMap.put(Key.NUM4, 5);
        lwjglKeyCodeMap.put(Key.NUM5, 6);
        lwjglKeyCodeMap.put(Key.NUM6, 7);
        lwjglKeyCodeMap.put(Key.NUM7, 8);
        lwjglKeyCodeMap.put(Key.NUM8, 9);
        lwjglKeyCodeMap.put(Key.NUM9, 10);
        lwjglKeyCodeMap.put(Key.NUM0, 11);
        lwjglKeyCodeMap.put(Key.MINUS, 12);
        lwjglKeyCodeMap.put(Key.EQUAL, 13);
        lwjglKeyCodeMap.put(Key.BACK, 14);
        lwjglKeyCodeMap.put(Key.TAB, 15);
        lwjglKeyCodeMap.put(Key.Q, 16);
        lwjglKeyCodeMap.put(Key.W, 17);
        lwjglKeyCodeMap.put(Key.E, 18);
        lwjglKeyCodeMap.put(Key.R, 19);
        lwjglKeyCodeMap.put(Key.T, 20);
        lwjglKeyCodeMap.put(Key.Y, 21);
        lwjglKeyCodeMap.put(Key.U, 22);
        lwjglKeyCodeMap.put(Key.I, 23);
        lwjglKeyCodeMap.put(Key.O, 24);
        lwjglKeyCodeMap.put(Key.P, 25);
        lwjglKeyCodeMap.put(Key.L_BRACKET, 26);
        lwjglKeyCodeMap.put(Key.R_BRACKET, 27);
        lwjglKeyCodeMap.put(Key.ENTER, 28);
        lwjglKeyCodeMap.put(Key.L_CONTROL, 29);
        lwjglKeyCodeMap.put(Key.A, 30);
        lwjglKeyCodeMap.put(Key.S, 31);
        lwjglKeyCodeMap.put(Key.D, 32);
        lwjglKeyCodeMap.put(Key.F, 33);
        lwjglKeyCodeMap.put(Key.G, 34);
        lwjglKeyCodeMap.put(Key.H, 35);
        lwjglKeyCodeMap.put(Key.J, 36);
        lwjglKeyCodeMap.put(Key.K, 37);
        lwjglKeyCodeMap.put(Key.L, 38);
        lwjglKeyCodeMap.put(Key.SEMICOLON, 39);
        lwjglKeyCodeMap.put(Key.APOSTROPHE, 40);
        lwjglKeyCodeMap.put(Key.GRAVE, 41);
        lwjglKeyCodeMap.put(Key.L_SHIFT, 42);
        lwjglKeyCodeMap.put(Key.BACKSLASH, 43);
        lwjglKeyCodeMap.put(Key.Z, 44);
        lwjglKeyCodeMap.put(Key.X, 45);
        lwjglKeyCodeMap.put(Key.C, 46);
        lwjglKeyCodeMap.put(Key.V, 47);
        lwjglKeyCodeMap.put(Key.B, 48);
        lwjglKeyCodeMap.put(Key.N, 49);
        lwjglKeyCodeMap.put(Key.M, 50);
        lwjglKeyCodeMap.put(Key.COMMA, 51);
        lwjglKeyCodeMap.put(Key.PERIOD, 52);
        lwjglKeyCodeMap.put(Key.SLASH, 53);
        lwjglKeyCodeMap.put(Key.R_SHIFT, 54);
        lwjglKeyCodeMap.put(Key.MULTIPLY, 55);
        lwjglKeyCodeMap.put(Key.L_ALT, 56);
        lwjglKeyCodeMap.put(Key.SPACE, 57);
        lwjglKeyCodeMap.put(Key.CAPS_LOCK, 58);
        lwjglKeyCodeMap.put(Key.F1, 59);
        lwjglKeyCodeMap.put(Key.F2, 60);
        lwjglKeyCodeMap.put(Key.F3, 61);
        lwjglKeyCodeMap.put(Key.F4, 62);
        lwjglKeyCodeMap.put(Key.F5, 63);
        lwjglKeyCodeMap.put(Key.F6, 64);
        lwjglKeyCodeMap.put(Key.F7, 65);
        lwjglKeyCodeMap.put(Key.F8, 66);
        lwjglKeyCodeMap.put(Key.F9, 67);
        lwjglKeyCodeMap.put(Key.F10, 68);
        lwjglKeyCodeMap.put(Key.NUM_LOCK, 69);
        lwjglKeyCodeMap.put(Key.SCROLL, 70);
        lwjglKeyCodeMap.put(Key.NUMPAD7, 71);
        lwjglKeyCodeMap.put(Key.NUMPAD8, 72);
        lwjglKeyCodeMap.put(Key.NUMPAD9, 73);
        lwjglKeyCodeMap.put(Key.SUBTRACT, 74);
        lwjglKeyCodeMap.put(Key.NUMPAD4, 75);
        lwjglKeyCodeMap.put(Key.NUMPAD5, 76);
        lwjglKeyCodeMap.put(Key.NUMPAD6, 77);
        lwjglKeyCodeMap.put(Key.ADD, 78);
        lwjglKeyCodeMap.put(Key.NUMPAD1, 79);
        lwjglKeyCodeMap.put(Key.NUMPAD2, 80);
        lwjglKeyCodeMap.put(Key.NUMPAD3, 81);
        lwjglKeyCodeMap.put(Key.NUMPAD0, 82);
        lwjglKeyCodeMap.put(Key.DECIMAL, 83);
        lwjglKeyCodeMap.put(Key.F11, 87);
        lwjglKeyCodeMap.put(Key.F12, 88);
        lwjglKeyCodeMap.put(Key.F13, 100);
        lwjglKeyCodeMap.put(Key.F14, 101);
        lwjglKeyCodeMap.put(Key.F15, 102);
        lwjglKeyCodeMap.put(Key.F16, 103);
        lwjglKeyCodeMap.put(Key.F17, 104);
        lwjglKeyCodeMap.put(Key.F18, 105);
        lwjglKeyCodeMap.put(Key.F19, 113);
        lwjglKeyCodeMap.put(Key.NUMPAD_EQUAL, 141);
        lwjglKeyCodeMap.put(Key.NUMPAD_ENTER, 156);
        lwjglKeyCodeMap.put(Key.R_CONTROL, 157);
        lwjglKeyCodeMap.put(Key.WORLD_1, 167);
        lwjglKeyCodeMap.put(Key.COMMA, 179);
        lwjglKeyCodeMap.put(Key.DIVIDE, 181);
        lwjglKeyCodeMap.put(Key.PRINT, 183);
        lwjglKeyCodeMap.put(Key.R_ALT, 184);
        lwjglKeyCodeMap.put(Key.PAUSE, 197);
        lwjglKeyCodeMap.put(Key.HOME, 199);
        lwjglKeyCodeMap.put(Key.ARROW_UP, 200);
        lwjglKeyCodeMap.put(Key.PAGE_UP, 201);
        lwjglKeyCodeMap.put(Key.ARROW_LEFT, 203);
        lwjglKeyCodeMap.put(Key.ARROW_RIGHT, 205);
        lwjglKeyCodeMap.put(Key.END, 207);
        lwjglKeyCodeMap.put(Key.ARROW_DOWN, 208);
        lwjglKeyCodeMap.put(Key.PAGE_DOWN, 209);
        lwjglKeyCodeMap.put(Key.INSERT, 210);
        lwjglKeyCodeMap.put(Key.DELETE, 211);
        lwjglKeyCodeMap.put(Key.L_WIN, 219);
        lwjglKeyCodeMap.put(Key.R_WIN, 220);
        lwjglKeyCodeMap.put(Key.MENU, 221);*/
    }
}
