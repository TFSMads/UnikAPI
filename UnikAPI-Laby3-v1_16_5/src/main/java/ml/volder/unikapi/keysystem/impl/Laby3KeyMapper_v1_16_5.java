package ml.volder.unikapi.keysystem.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.keysystem.Key;
import ml.volder.unikapi.keysystem.KeyMapper;
import ml.volder.unikapi.keysystem.MouseButton;
import net.labymod.utils.Keyboard;

import java.util.HashMap;
import java.util.Map;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3KeyMapper_v1_16_5 extends KeyMapper {

    private static Laby3KeyMapper_v1_16_5 instance;

    public static Laby3KeyMapper_v1_16_5 getAPI() {
        if(instance == null)
            instance = new Laby3KeyMapper_v1_16_5();
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
        return Keyboard.isNewKeyDown(getGlfwKeyCode(key));
    }

    @Override
    public void initialize() {

    }

    @Override
    public void register(Key key, int i) {

    }


    private static final int DEFAULT_KEYCODE = -1;
    private static final Key DEFAULT_KEY = Key.NONE;
    private static Map<Integer, Key> glfwKeyCodeMap;
    private static Map<Integer, MouseButton> glfwMouseCodeMap;

    public static int getGlfwKeyCode(Key key) {
        if(glfwKeyCodeMap == null)
            register();
        for(Map.Entry<Integer, Key> entry: glfwKeyCodeMap.entrySet()){
            if(entry.getValue().equals(key))
                return entry.getKey();
        }
        return DEFAULT_KEYCODE;
    }

    public static Key getKeyByGlfwKeyCode(int keyCode) {
        if(glfwKeyCodeMap == null)
            register();
        return glfwKeyCodeMap.getOrDefault(keyCode, DEFAULT_KEY);
    }

    public static int getGlfwMouseButton(MouseButton mouseButton) {
        if(glfwMouseCodeMap == null)
            register();
        for(Map.Entry<Integer, MouseButton> entry: glfwMouseCodeMap.entrySet()){
            if(entry.getValue().equals(mouseButton))
                return entry.getKey();
        }
        return DEFAULT_KEYCODE;
    }

    public static MouseButton getMouseButtonByGlfwKeyCode(int keyCode) {
        if(glfwMouseCodeMap == null)
            register();
        return glfwMouseCodeMap.getOrDefault(keyCode, null);
    }

    static {
        if(glfwKeyCodeMap == null || glfwMouseCodeMap == null) {
            register();
        }
    }

    private static void register() {

        if(glfwMouseCodeMap == null){
            MouseButton.initialize();
            if(MouseButton.LEFT == null) {
                //Can't register keys is not yet initialized
                return;
            }

            glfwMouseCodeMap = new HashMap<>();

            glfwMouseCodeMap.put(0, (MouseButton) MouseButton.LEFT);
            glfwMouseCodeMap.put(1, (MouseButton) MouseButton.RIGHT);
            glfwMouseCodeMap.put(2, (MouseButton) MouseButton.MIDDLE);
            glfwMouseCodeMap.put(3, (MouseButton) MouseButton.M4);
            glfwMouseCodeMap.put(4, (MouseButton) MouseButton.M5);
            glfwMouseCodeMap.put(5, (MouseButton) MouseButton.M6);
            glfwMouseCodeMap.put(6, (MouseButton) MouseButton.M7);
            glfwMouseCodeMap.put(7, (MouseButton) MouseButton.M8);

        }

        if(glfwKeyCodeMap == null) {
            Key.initialize();
            if(Key.NONE == null) {
                //Can't register keys is not yet initialized
                return;
            }

            glfwKeyCodeMap = new HashMap<>();

            glfwKeyCodeMap.put(-1, Key.NONE);

            glfwKeyCodeMap.put(256, Key.ESCAPE);
            glfwKeyCodeMap.put(290, Key.F1);
            glfwKeyCodeMap.put(291, Key.F2);
            glfwKeyCodeMap.put(292, Key.F3);
            glfwKeyCodeMap.put(293, Key.F4);
            glfwKeyCodeMap.put(294, Key.F5);
            glfwKeyCodeMap.put(295, Key.F6);
            glfwKeyCodeMap.put(296, Key.F7);
            glfwKeyCodeMap.put(297, Key.F8);
            glfwKeyCodeMap.put(298, Key.F9);
            glfwKeyCodeMap.put(299, Key.F10);
            glfwKeyCodeMap.put(300, Key.F11);
            glfwKeyCodeMap.put(301, Key.F12);
            glfwKeyCodeMap.put(302, Key.F13);
            glfwKeyCodeMap.put(303, Key.F14);
            glfwKeyCodeMap.put(304, Key.F15);
            glfwKeyCodeMap.put(305, Key.F16);
            glfwKeyCodeMap.put(306, Key.F17);
            glfwKeyCodeMap.put(307, Key.F18);
            glfwKeyCodeMap.put(308, Key.F19);
            glfwKeyCodeMap.put(309, Key.F20);
            glfwKeyCodeMap.put(310, Key.F21);
            glfwKeyCodeMap.put(311, Key.F22);
            glfwKeyCodeMap.put(312, Key.F23);
            glfwKeyCodeMap.put(313, Key.F24);
            glfwKeyCodeMap.put(314, Key.F25);
            glfwKeyCodeMap.put(96, Key.GRAVE);
            glfwKeyCodeMap.put(49, Key.NUM1);
            glfwKeyCodeMap.put(50, Key.NUM2);
            glfwKeyCodeMap.put(51, Key.NUM3);
            glfwKeyCodeMap.put(52, Key.NUM4);
            glfwKeyCodeMap.put(53, Key.NUM5);
            glfwKeyCodeMap.put(54, Key.NUM6);
            glfwKeyCodeMap.put(55, Key.NUM7);
            glfwKeyCodeMap.put(56, Key.NUM8);
            glfwKeyCodeMap.put(57, Key.NUM9);
            glfwKeyCodeMap.put(48, Key.NUM0);
            glfwKeyCodeMap.put(45, Key.MINUS);
            glfwKeyCodeMap.put(61, Key.EQUAL);
            glfwKeyCodeMap.put(259, Key.BACK);
            glfwKeyCodeMap.put(258, Key.TAB);
            glfwKeyCodeMap.put(81, Key.Q);
            glfwKeyCodeMap.put(87, Key.W);
            glfwKeyCodeMap.put(69, Key.E);
            glfwKeyCodeMap.put(82, Key.R);
            glfwKeyCodeMap.put(84, Key.T);
            glfwKeyCodeMap.put(89, Key.Y);
            glfwKeyCodeMap.put(85, Key.U);
            glfwKeyCodeMap.put(73, Key.I);
            glfwKeyCodeMap.put(79, Key.O);
            glfwKeyCodeMap.put(80, Key.P);
            glfwKeyCodeMap.put(91, Key.L_BRACKET);
            glfwKeyCodeMap.put(93, Key.R_BRACKET);
            glfwKeyCodeMap.put(92, Key.BACKSLASH);
            glfwKeyCodeMap.put(280, Key.CAPS_LOCK);
            glfwKeyCodeMap.put(65, Key.A);
            glfwKeyCodeMap.put(83, Key.S);
            glfwKeyCodeMap.put(68, Key.D);
            glfwKeyCodeMap.put(70, Key.F);
            glfwKeyCodeMap.put(71, Key.G);
            glfwKeyCodeMap.put(72, Key.H);
            glfwKeyCodeMap.put(74, Key.J);
            glfwKeyCodeMap.put(75, Key.K);
            glfwKeyCodeMap.put(76, Key.L);
            glfwKeyCodeMap.put(59, Key.SEMICOLON);
            glfwKeyCodeMap.put(39, Key.APOSTROPHE);
            glfwKeyCodeMap.put(257, Key.ENTER);
            glfwKeyCodeMap.put(340, Key.L_SHIFT);
            glfwKeyCodeMap.put(90, Key.Z);
            glfwKeyCodeMap.put(88, Key.X);
            glfwKeyCodeMap.put(67, Key.C);
            glfwKeyCodeMap.put(86, Key.V);
            glfwKeyCodeMap.put(66, Key.B);
            glfwKeyCodeMap.put(78, Key.N);
            glfwKeyCodeMap.put(77, Key.M);
            glfwKeyCodeMap.put(44, Key.COMMA);
            glfwKeyCodeMap.put(46, Key.PERIOD);
            glfwKeyCodeMap.put(47, Key.SLASH);
            glfwKeyCodeMap.put(344, Key.R_SHIFT);
            glfwKeyCodeMap.put(341, Key.L_CONTROL);
            glfwKeyCodeMap.put(343, Key.L_WIN);
            glfwKeyCodeMap.put(342, Key.L_ALT);
            glfwKeyCodeMap.put(32, Key.SPACE);
            glfwKeyCodeMap.put(346, Key.R_ALT);
            glfwKeyCodeMap.put(347, Key.R_WIN);
            glfwKeyCodeMap.put(348, Key.MENU);
            glfwKeyCodeMap.put(345, Key.R_CONTROL);
            glfwKeyCodeMap.put(263, Key.ARROW_LEFT);
            glfwKeyCodeMap.put(264, Key.ARROW_DOWN);
            glfwKeyCodeMap.put(262, Key.ARROW_RIGHT);
            glfwKeyCodeMap.put(265, Key.ARROW_UP);
            glfwKeyCodeMap.put(260, Key.INSERT);
            glfwKeyCodeMap.put(268, Key.HOME);
            glfwKeyCodeMap.put(266, Key.PAGE_UP);
            glfwKeyCodeMap.put(261, Key.DELETE);
            glfwKeyCodeMap.put(269, Key.END);
            glfwKeyCodeMap.put(267, Key.PAGE_DOWN);
            glfwKeyCodeMap.put(283, Key.PRINT);
            glfwKeyCodeMap.put(281, Key.SCROLL);
            glfwKeyCodeMap.put(284, Key.PAUSE);
            glfwKeyCodeMap.put(282, Key.NUM_LOCK);
            glfwKeyCodeMap.put(331, Key.DIVIDE);
            glfwKeyCodeMap.put(332, Key.MULTIPLY);
            glfwKeyCodeMap.put(333, Key.SUBTRACT);
            glfwKeyCodeMap.put(334, Key.ADD);
            glfwKeyCodeMap.put(336, Key.NUMPAD_EQUAL);
            glfwKeyCodeMap.put(335, Key.NUMPAD_ENTER);
            glfwKeyCodeMap.put(330, Key.DECIMAL);
            glfwKeyCodeMap.put(320, Key.NUMPAD0);
            glfwKeyCodeMap.put(321, Key.NUMPAD1);
            glfwKeyCodeMap.put(322, Key.NUMPAD2);
            glfwKeyCodeMap.put(323, Key.NUMPAD3);
            glfwKeyCodeMap.put(324, Key.NUMPAD4);
            glfwKeyCodeMap.put(325, Key.NUMPAD5);
            glfwKeyCodeMap.put(326, Key.NUMPAD6);
            glfwKeyCodeMap.put(327, Key.NUMPAD7);
            glfwKeyCodeMap.put(328, Key.NUMPAD8);
            glfwKeyCodeMap.put(329, Key.NUMPAD9);
            glfwKeyCodeMap.put(161, Key.WORLD_1);
            glfwKeyCodeMap.put(162, Key.WORLD_2);
        }
    }

}
