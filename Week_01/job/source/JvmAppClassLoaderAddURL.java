import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JvmAppClassLoaderAddURL {
    public static void main(String[] args) {
        try {
            String appPath = "file:../resource/Hello";
            URLClassLoader urlClassLoader = (URLClassLoader)JvmAppClassLoaderAddURL.class.getClassLoader();
            Method addUrl = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addUrl.setAccessible(true);
            URL url = new URL(appPath);
            addUrl.invoke(urlClassLoader, url);
            Class.forName("Hello");//效果跟Class.forName("jvm.Hello").newInstance()一样
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
