package enumerated.menu;

import net.lh.util.Enums;

/**
 * @author lh
 * More succinct
 */
public enum  SecurityCategory {
   STOCK(Security.Stock.class),
   BOUND(Security.BOND.class);
   Security[] values;
   SecurityCategory(Class<? extends Security> kind) {
      values = kind.getEnumConstants();
   }

   interface Security{
      enum Stock implements Security{
         SHORT,LONG,MARGIN
      }
      enum BOND implements Security{
         MUNICIPAL,JUNK
      }
   }

   public Security randomSelection() {
      return Enums.random(values);
   }

   public static void main(String[] args) {
      for (int i = 0; i < 10; i++) {
         SecurityCategory category = Enums.random(SecurityCategory.class);
         System.out.println(category + ": " + category.randomSelection());
      }
   }
}
