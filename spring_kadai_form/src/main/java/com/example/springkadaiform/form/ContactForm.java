package com.example.springkadaiform.form;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

/*フォームクラスを定義し、お問い合わせフォームの各入力項目を管理。
 * バリデーション条件（後述）も設定する。
 */

@Data
public class ContactForm {

	@NotBlank(message = "お名前を入力してください")
	 private String name;//お名前

	    // メールアドレス
	@NotBlank(message = "メールアドレスの入力形式が正しくありません")
	    private String email;

	    // お問い合わせ内容
	@NotBlank(message = "お問い合わせ内容を確認してください")
	    private String message;
	
	
	/* public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getMessage() { return message; }
	    public void setMessage(String message) { this.message = message; }*/
}
