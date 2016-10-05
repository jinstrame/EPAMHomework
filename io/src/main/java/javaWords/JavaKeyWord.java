package javaWords;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("WeakerAccess")
@RequiredArgsConstructor
public enum JavaKeyWord {
    ABSTRACT("abstract"),
    ASSERT("assert"),
    BOOLEAN("boolean"),
    BREAK("break"),
    BYTE("byte"),
    CASE("case"),
    CATCH("catch"),
    CHAR("char"),
    CLASS("class"),
    CONST("const"),
    CONTINUE("continue"),
    DEFAULT("default"),
    DO("do"),
    DOUBLE("double"),
    ELSE("else"),
    ENUM("enum"),
    EXTENDS("extends"),
    FINAL("final"),
    FINALLY("finally"),
    FLOAT("float"),
    FOR("for"),
    GOTO("goto"),
    IF("if"),
    IMPLEMENTS("implements"),
    IMPORT("import"),
    INSTANCEOF("instanceof"),
    INT("int"),
    INTERFACE("interface"),
    LONG("long"),
    NATIVE("native"),
    NEW("new"),
    PACKAGE("package"),
    PRIVATE("private"),
    PROTECTED("protected"),
    PUBLIC("public"),
    RETURN("return"),
    SHORT("short"),
    STATIC("static"),
    STRICTFP("strictfp"),
    SUPER("super"),
    SWITCH("switch"),
    SYNCHRONIZED("synchronized"),
    THIS("this"),
    THROW("throw"),
    THROWS("throws"),
    TRANSIENT("transient"),
    TRY("try"),
    VOID("void"),
    VOLATILE("volatile"),
    WHILE("while");

    @Getter
    private int count;

    @Getter
    private final String value;

    private static JavaKeyWord[] javaKeyWords = JavaKeyWord.values();

    private boolean isValue(String name){
        return this.value.equals(name);
    }

    public static JavaKeyWord getWord(String name){
        for (JavaKeyWord i : javaKeyWords){
            if (i.isValue(name))
                return i;
        }
        return null;
    }

    public void plusPlus(){
        count++;
    }

    public static void reset(){
        for (JavaKeyWord i : javaKeyWords){
            i.count = 0;
        }
    }

    @Override
    public String toString() {
        return value + " " + Integer.toString(count);
    }


}
