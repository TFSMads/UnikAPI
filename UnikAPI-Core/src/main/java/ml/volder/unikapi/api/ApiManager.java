package ml.volder.unikapi.api;

import ml.volder.unikapi.NotSupportedAPIException;
import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.UnikAPI;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//TODO Omkode til ikke at benytte Refelctions.
public class ApiManager {

    private static Map<String, Object> cachedAPIMap = new HashMap<>();

    public static <T> T getAPI(String apiName, String packageName, Class<T> expectedReturnType) {
        if(cachedAPIMap.containsKey(apiName) && cachedAPIMap != null)
            return (T) cachedAPIMap.get(apiName);
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends T>> classes = reflections.getSubTypesOf(expectedReturnType);
        for (Class<? extends T> klass: classes) {
            if(klass.isAnnotationPresent(SupportedClient.class) && UnikAPI.isSupported(klass.getAnnotation(SupportedClient.class))) {
                try {
                    Method method = klass.getDeclaredMethod("getAPI", null);
                    if(method == null)
                        continue;
                    T playerAPI = (T) method.invoke(null, null);
                    if(playerAPI == null)
                        continue;
                    cachedAPIMap.put(apiName, playerAPI);
                    return playerAPI;
                } catch (Exception e) {
                    return null;
                }
            }
        }
        throw new NotSupportedAPIException(apiName, packageName, expectedReturnType.getName());
    }

    private static Map<String, Class> cachedClassAPIMap = new HashMap<>();

    public static Class getClassAPI(String apiName, String packageName, Class expectedReturnType) {
        if(cachedClassAPIMap.containsKey(apiName) && cachedClassAPIMap != null)
            return cachedClassAPIMap.get(apiName);
        Reflections reflections = new Reflections(packageName);
        Set<Class> classes = reflections.getSubTypesOf(expectedReturnType);
        for (Class klass: classes) {
            if(klass.isAnnotationPresent(SupportedClient.class) && UnikAPI.isSupported((SupportedClient) klass.getAnnotation(SupportedClient.class))) {
                try {
                    cachedClassAPIMap.put(apiName, klass);
                    return klass;
                } catch (Exception e) {
                    return null;
                }
            }
        }
        throw new NotSupportedAPIException(apiName, packageName, expectedReturnType.getName());
    }
}
