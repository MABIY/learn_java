package access.cookie2;

/**
 * @author lh
 * Show that protected methods have package access but are not public.
 **/
public class CookieMonster {
    public static void main(String[] args) {
        Cookie x = new Cookie();
        x.bite(); // package access to protected method
    }
}
