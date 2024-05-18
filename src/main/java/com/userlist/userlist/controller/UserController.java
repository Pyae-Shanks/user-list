package com.userlist.userlist.controller;

import com.userlist.userlist.entity.User;
import com.userlist.userlist.entity.UserActivityLog;
import com.userlist.userlist.service.UserActivityLogService;
import com.userlist.userlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired private UserActivityLogService userActivityLogService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //
    // handler method to handle list users and return model and view
    //
    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/{id}")
    public String saveEditUser(@PathVariable Long id, @ModelAttribute("user") User user,@RequestBody MultiValueMap<String, String> formData) {
        User existingUser = userService.getUserById(id);
        String editTxt = "Edit";
        String[] changedValue = {user.getFirstName(), user.getLastName(), user.getEmail()};
        String[] oriValue = {existingUser.getFirstName(), existingUser.getLastName(), existingUser.getEmail()};
        Set<String> fieldName = formData.keySet();


        String conditionedValue = "";
        String originalValue = "";
        String conditionedField = "";
        for (int i = 0; i < changedValue.length; i++) {
            if (!changedValue[i].equals(oriValue[i])) {
                //conditionedValue += "\"field"+ i +"\":" +changedValue[i] + ", ";
                conditionedValue += changedValue[i] + ", ";
                conditionedField += fieldName + ", ";
                originalValue += oriValue[i] + ", ";
            }
        }

        //conditionedValue = conditionedValue.substring(0, conditionedValue.length()-1);
        //conditionedValue += "}";
        System.out.println("edited Id: "+ user.getId() +"\nChanged field >>>>> "+ conditionedField);
        System.out.println("Changed Value From This >>>>>> " + originalValue);
        System.out.println("To This >>>>>> " + conditionedValue);

        // Saving data to User Activity Log
        UserActivityLog userActivityLog = new UserActivityLog();
        userActivityLog.setAction(editTxt);
        userActivityLog.setEditedId(user.getId());
        userActivityLog.setChangedField(conditionedField);
        userActivityLog.setValueFrom(originalValue);
        userActivityLog.setValueTo(conditionedValue);
        userActivityLog.setUser(user);
        userActivityLogService.saveActivityLog(userActivityLog);

        // Saving Data to User Table
        existingUser.setId(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.isDeletedUser(false);
        userService.editUser(existingUser);
        return "redirect:/";
    }

//    @GetMapping("/{id}")
//    public String deleteUser(@PathVariable Long id){
//        userService.deleteUser(id);
//        return "redirect:/";
//    }

    //--------------------------------------------

//    @GetMapping("/{id}")
//    public String deleteUserBoolean(@PathVariable Long id){
//        final User userById = userService.getUserById(id);
//        return "users";
//    }

    @PostMapping("/userDelete")
    @ResponseBody
    public String removeDeletedUser(Long id, @ModelAttribute("user") User user) {
        System.out.println("******************************* " + id);
        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setDeletedUser(true);
        userService.editUser(existingUser);
        return "Success";
    }

    @GetMapping("/userDetail/{id}")
    public String userDetail(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userDetail";
    }
}
