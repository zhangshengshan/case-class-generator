package com.julianpeeters.caseclass.generator
import artisanal.pickle.maker._
import scala.reflect.internal.pickling._
import org.objectweb.asm._
import Opcodes._

case class ProductPrefix(cw: ClassWriter, var mv: MethodVisitor, caseClassName: String, fieldData: List[EnrichedField]) {
  def dump = {
    mv = cw.visitMethod(ACC_PUBLIC, "productPrefix", "()Ljava/lang/String;", null, null);
    mv.visitCode();
    mv.visitLdcInsn(caseClassName.split('/').last);
    mv.visitInsn(ARETURN);
    mv.visitMaxs(1, 1);
    mv.visitEnd();
  }
}
