package idrabenia.webtest.ui

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import idrabenia.webtest.domain.User
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import javax.validation.Valid

/**
 * 
 * @author Ilya Drabenia
 * @since 26.01.13
 */
@Controller
class UserController {

    @RequestMapping("/user")
    String user() {
        return "user"
    }

    @RequestMapping("/user/save")
    String saveUser(@Valid User user, BindingResult result, Model model) {
        model.addAttribute("binding", result)

        return "formResponseView"
    }

}
