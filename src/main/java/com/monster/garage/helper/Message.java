package com.monster.garage.helper;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Message {
  public void showSuccessMessage(RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("message", "Success. Record Removed");
    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
  }

  public void showFailMessage(RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("message", "An error occurred");
    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
  }
}
