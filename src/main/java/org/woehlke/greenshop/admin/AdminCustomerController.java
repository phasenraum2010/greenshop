package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.model.OrderAdminBean;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.customer.model.CustomerBean;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminCustomerController {

    @Inject
    private AdminService adminService;

    @Inject
    private CatalogService catalogService;

    @RequestMapping(value = "/admin/customers", method = RequestMethod.GET)
    public String customers(Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<CustomerBean> customers = adminService.findAllCustomers();
        model.addAttribute("customers",customers);
        CustomerBean thisCustomer = null;
        int thisCustomersNumberOfReviews = 0;
        if(customers.size()>0){
            thisCustomer = customers.iterator().next();
            thisCustomersNumberOfReviews = adminService.getNumberOfReviewsForCustomer(thisCustomer.getCustomer());
        }
        model.addAttribute("thisCustomer",thisCustomer);
        model.addAttribute("thisCustomersNumberOfReviews",thisCustomersNumberOfReviews);
        return "admin/customers";
    }

    @RequestMapping(value = "/admin/customers/{customerId}", method = RequestMethod.GET)
    public String customerId(@PathVariable long customerId, Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<CustomerBean> customers = adminService.findAllCustomers();
        model.addAttribute("customers",customers);
        CustomerBean thisCustomer = adminService.getCustomerById(customerId);
        int thisCustomersNumberOfReviews = adminService.getNumberOfReviewsForCustomer(thisCustomer.getCustomer());
        model.addAttribute("thisCustomer",thisCustomer);
        model.addAttribute("thisCustomersNumberOfReviews",thisCustomersNumberOfReviews);
        return "admin/customers";
    }

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public String orders(Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        List<OrderAdminBean> orders = adminService.getAllOrders(language);
        model.addAttribute("orders",orders);
        OrderAdminBean thisOrder = null;
        if(orders.size()>0){
            thisOrder = orders.iterator().next();
        }
        model.addAttribute("thisOrder",thisOrder);
        return "admin/orders";
    }

    @RequestMapping(value = "/admin/orders/{orderId}", method = RequestMethod.GET)
    public String orderId(@PathVariable long orderId, Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        List<OrderAdminBean> orders = adminService.getAllOrders(language);
        model.addAttribute("orders",orders);
        OrderAdminBean thisOrder = adminService.findOrderById(orderId,language);
        model.addAttribute("thisOrder",thisOrder);
        return "admin/orders";
    }
}
