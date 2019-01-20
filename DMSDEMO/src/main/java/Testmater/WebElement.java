package Testmater;
//Class được sử dụng để nhóm các test method theo funtion/feature
//Class được sử dụng để xây dựng lên các abiities;
//
public class WebElement {
	String Value;
	String css;
/*public WebElement(String Value) {
	this.Value = Value;
	//this.css = css;
}*/
public void imput(String Value) {
	this.Value =Value;
}
public void addcss(String css) {
	this.css = css;
}
public void DoAction() {
	System.out.println(this.Value);
	System.out.println(this.css);
}

}
