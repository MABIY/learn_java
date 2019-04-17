package access;

import access.cookie2.Cookie;

/**
 * @author lh
 * Show that protected methods have package access but are not public.
 **/
public class CookieThief {
    public static void main(String[] args) {
        Cookie x = new Cookie();
        // x.bite(); // access protected
    }
}
