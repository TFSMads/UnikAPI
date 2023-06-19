package ml.volder.unikapi.transformer;

import ml.volder.unikapi.event.events.clientkeypressevent.impl.Laby3KeyPressEvent_v1_12_2;
import net.labymod.core.asm.global.ClassEditor;
import net.minecraft.client.Minecraft;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.util.List;
import java.util.ListIterator;

public class MinecraftEditor extends ClassEditor {

    private boolean isObf;

    public MinecraftEditor(ClassEditorType type, boolean isObf) {
        super(type);
        this.isObf = isObf;
    }

    @Override
    public void accept(String name, ClassNode node) {
        List<MethodNode> methodList = node.methods;

        for (MethodNode methodNode : methodList) {
            if (this.isObf ? methodNode.name.equals("W") : methodNode.name.equals("dispatchKeypresses")) {
                AbstractInsnNode insertLocation = null;
                for (ListIterator<AbstractInsnNode> it = methodNode.instructions.iterator(); it.hasNext(); ) {
                    AbstractInsnNode instruciton = it.next();
                    if(instruciton.getOpcode() == Opcodes.RETURN) {
                        insertLocation = instruciton;
                    }
                }
                if(insertLocation != null) {
                    InsnList list = new InsnList();
                    list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, Type.getInternalName(Laby3KeyPressEvent_v1_12_2.class), "callOnKeyPress", "()V"));
                    methodNode.instructions.insertBefore(insertLocation, list);
                }

            }
        }


    }

}
