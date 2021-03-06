package org.woehlke.greenshop.backend.localization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.backend.AdminMenuCategory;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class CurrencyController {

    @RequestMapping(value = "/admin/currencies", method = RequestMethod.GET)
    public String currencies(Model model){
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/localization/currencies";
    }
}
