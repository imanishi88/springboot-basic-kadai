package com.example.springkadaiform.controller;


import org.springframework.core.Conventions;
/*フォーム・確認画面への各リクエストに応じて、適切なビューを表示。
 * バリデーション結果に応じて、表示内容を切り替える必要がある。

バリデーションOK：確認画面を表示
バリデーションNG：元のフォームへリダイレクト*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	

   @GetMapping("/form")
    public String showForm(Model model) {
	   
    	 model.addAttribute("contactForm", new ContactForm());
    	 
         return "contactFormView"; // contactformview.html を表示
        
		}
	
	
	 @PostMapping("/confirm")
	 
    public String confirm(RedirectAttributes redirectAttributes,
    		
    		@Validated ContactForm form, BindingResult result) {
      
		 if (result.hasErrors()) {
			 
			 // フォームクラスをビューに受け渡す
	           redirectAttributes.addFlashAttribute("contactForm", form);
	            // バリデーション結果をビューに受け渡す
	            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
	                    + Conventions.getVariableName(form), result);

			 
	            return "contactFormView";
           //return "redirect:/form"; // バリデーションNGならフォームへリダイレクト
        }
		 
        return "confirmView"; // バリデーションOKなら確認画面(confirm.html)を表示
    }
}

