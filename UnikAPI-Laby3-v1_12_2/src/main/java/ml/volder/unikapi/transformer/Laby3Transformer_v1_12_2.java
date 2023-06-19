package ml.volder.unikapi.transformer;

import net.labymod.core.LabyModCore;
import net.labymod.core.asm.LabyModCoreMod;
import net.labymod.core.asm.global.ClassEditor;
import net.labymod.support.util.Debug;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

public class Laby3Transformer_v1_12_2 implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        boolean obf = LabyModCoreMod.isObfuscated();
        if(obf ? name.equals("bib") : name.equals("net.minecraft.client.Minecraft")) {
            System.out.println("[UnikAPI] Transforming Minecraft class: " + name);
            ClassEditor editor = new MinecraftEditor(ClassEditor.ClassEditorType.CLASS_NODE, obf);
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(basicClass);
            classReader.accept(classNode, 0);
            editor.accept(name, classNode);
            ClassWriter classWriter = new ClassWriter(3);
            classNode.accept(classWriter);
            return classWriter.toByteArray();
        }
        return basicClass;
    }
}
