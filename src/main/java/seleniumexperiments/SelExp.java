package seleniumexperiments;

import org.openqa.selenium.By;

public class SelExp {

    private static final By mat_iconCommentProductPriceModifiersViewComment = By.xpath("//mat-icon[contains(@class,'productPriceModifiersViewCommentAutomate')]");
    public static void main(String[] args) {


        System.out.println(mat_iconCommentProductPriceModifiersViewComment.toString());

        System.out.println(mat_iconCommentProductPriceModifiersViewComment.toString().split("By.xpath:")[1].trim());

    }
}
