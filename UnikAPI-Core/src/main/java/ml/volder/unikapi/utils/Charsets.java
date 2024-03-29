package ml.volder.unikapi.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Charsets {
    /** @deprecated */
    @Deprecated
    public static final Charset ISO_8859_1;
    /** @deprecated */
    @Deprecated
    public static final Charset US_ASCII;
    /** @deprecated */
    @Deprecated
    public static final Charset UTF_16;
    /** @deprecated */
    @Deprecated
    public static final Charset UTF_16BE;
    /** @deprecated */
    @Deprecated
    public static final Charset UTF_16LE;
    /** @deprecated */
    @Deprecated
    public static final Charset UTF_8;

    public Charsets() {
    }

    public static SortedMap<String, Charset> requiredCharsets() {
        TreeMap<String, Charset> m = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        m.put(StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1);
        m.put(StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII);
        m.put(StandardCharsets.UTF_16.name(), StandardCharsets.UTF_16);
        m.put(StandardCharsets.UTF_16BE.name(), StandardCharsets.UTF_16BE);
        m.put(StandardCharsets.UTF_16LE.name(), StandardCharsets.UTF_16LE);
        m.put(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8);
        return Collections.unmodifiableSortedMap(m);
    }

    public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset toCharset(String charset) {
        return charset == null ? Charset.defaultCharset() : Charset.forName(charset);
    }

    static {
        ISO_8859_1 = StandardCharsets.ISO_8859_1;
        US_ASCII = StandardCharsets.US_ASCII;
        UTF_16 = StandardCharsets.UTF_16;
        UTF_16BE = StandardCharsets.UTF_16BE;
        UTF_16LE = StandardCharsets.UTF_16LE;
        UTF_8 = StandardCharsets.UTF_8;
    }
}