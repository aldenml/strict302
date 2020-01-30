
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/aldenml/Development/strict302/conf/routes
// @DATE:Thu Jan 30 18:16:49 EST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
