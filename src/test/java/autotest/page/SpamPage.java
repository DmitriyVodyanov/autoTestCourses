package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import static org.openqa.selenium.By.cssSelector;

public class SpamPage extends BasePage {

    private String LOGIN = "+79273850351";
    private String PASSWORD = "rebulo83";
    private String SPAM_PAGE_ADDRES = "https://vk.com/vikysika123";
    private String SPAM_PAGE_ADDRES1 = "https://vk.com/id576324728";
    private String SPAM_PAGE_ADDRES2 = "https://vk.com/vv.mous";
    private String SPAM_PAGE_ADDRES3 = "https://vk.com/cdelayu_kus";
    private String SPAM_PAGE_ADDRES4 = "https://vk.com/id578574920";
    private String SPAM_PAGE_ADDRES5 = "https://vk.com/kachareeeeeshka";
    private String SPAM_MY_PAGE = "https://vk.com/id8132268";

    public String getSPAM_MESSAGE() {
        return SPAM_MESSAGE;
    }

    private String SPAM_MESSAGE = "Koronavirüs Nedeniyle Evde Karantina Altında Olacaklar İçin Nevruz Ateşi Yöntemi\n" +
            "\n" +
            "Koronavirüs Salgını: 2 Ülkede Daha İlk Ölümler Gerçekleşti\n" +
            "\n" +
            "'Koronavirüsten Koruyor' İddiası Yayılan İlaç Hakkında Uzmanlar Uyardı: Ölümcül Yan Etkileri Olabilir\n" +
            "\n" +
            "Sağlık Bakanı 'Yaşlı Hastalarımızdan 12'sini Kaybettik' Dedi: Can Kaybı 21'e Vaka Sayısı 947'ye Yükseldi\n" +
            "\n" +
            "65 Yaş ve Üstü Kişilere Sokağa Çıkma Yasağı\n" +
            "\n" +
            "'Torunlarınızın Talebiyle Bu Önlemi Aldık': Ankara ve İzmir'de 65 Yaş Üstü Ücretsiz Toplu Taşıma Uygulaması Kaldırıldı\n" +
            "\n" +
            "Koronaya Karşı Önlem İçin İçiyorlar: İran'da Sahte İçkiden Zehirlenen 194 Kişi Hayatını Kaybetti\n" +
            "\n" +
            "Bu Sıkıntılı Günlerde Tüm Dertlerinizi Alıp Götürecek Kadar Güçlü İç Isıtan 15 Fotoğraf\n" +
            "\n" +
            "Koronavirüs Nedeniyle Evde Karantina Altında Olacaklar İçin Nevruz Ateşi Yöntemi\n" +
            "\n" +
            "Koronavirüs Salgını: 2 Ülkede Daha İlk Ölümler Gerçekleşti\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "6\n" +
            "7\n" +
            "8\n" +
            "\n" +
            "Evinizin Küçükleriyle Kaliteli Vakit Geçirmek İçin Eğlendirirken Öğretmeyi Hedefleyen Birbirinden İlginç 19 Belgesel\n" +
            "\n" +
            "Bugünlerde Can Sıkıntınıza Çare Olacak Birbirinden Eğlenceli En İyi Mobil Strateji Oyunları\n" +
            "\n" +
            "Aile Üyelerini Mizahlarına Alet Eden Goygoyculardan Haftanın En Eğlenceli 17 Paylaşımı\n" +
            "Haberler\n" +
            "Koronavirüs Salgını: Enfeksiyona Yakalanma Riski En Yüksek Meslekler Hangileri?\n" +
            "Koronavirüs Salgını: Enfeksiyona Yakalanma Riski En Yüksek Meslekler Hangileri?\n" +
            "Tüm dünyayı saran koronavirüs bütün insanların sağlığını tehd...\n" +
            "\n" +
            "22 Mart, 10:25\n" +
            "Hırvatistan'ın Başkenti Zagreb'de 5.3 Büyüklüğünde Deprem\n" +
            "Hırvatistan'ın Başkenti Zagreb'de 5.3 Büyüklüğünde Deprem\n" +
            "Hırvatistan'ın başkenti Zagreb'in kuzeyinde bu sabah saatlerinde 5.3 büyüklüğünde b...\n" +
            "\n" +
            "22 Mart, 10:05\n" +
            "15 Dakikada Sonuç Veren Yeni Tanı Kiti Uygulanmaya Başladı\n" +
            "15 Dakikada Sonuç Veren Yeni Tanı Kiti Uygulanmaya Başladı\n" +
            "Sağlık Bakanlığı tüm dünyada etkili olan ve binlerce insanın ölümüne neden olan ko...\n" +
            "\n" +
            "21 Mart, 18:10\n" +
            "#EvdeKal Çağrıları Karşılık Bulmadı: Vatandaşlar Sahil ve Piknik Alanlarını Doldurdu\n" +
            "#EvdeKal Çağrıları Karşılık Bulmadı: Vatandaşlar Sahil ve Piknik Alanlarını Doldurdu\n" +
            "Yetkililerin uyarılarına rağmen vatandaşlar evlerinde ka...\n";

    private By inputLogin = cssSelector("#index_email");
    private By inputPassword = cssSelector("#index_pass");
    private By buttonLogin = cssSelector("#index_login_button");
    private By buttonSendMessage = cssSelector(".profile_btn_cut_left");
    private By inputMessage = cssSelector("#mail_box_editable");
    private By buttonSend = cssSelector("#mail_box_send");
    private By buttonComment = cssSelector("._like_wall480686132_549 > div:nth-child(1) > div:nth-child(1) > a:nth-child(3)");
    private By inputCommentPost = cssSelector("#reply_field480686132_549");
    private By buttonSendComment = cssSelector("#reply_button480686132_549");

    public SpamPage(WebDriver driver) {
        super(driver);
    }

    public void loginAccount(String pass, String log) {
        clickByElement(inputLogin);
        sendKeysByElement(inputLogin, log);
        clickByElement(inputPassword);
        sendKeysByElement(inputPassword, pass);
        clickByElement(buttonLogin);

    }

    public void sendMessage(String message) {
//        driver.get(SPAM_MY_PAGE);

        for (int count = 0; count < 10; count++) {

            try {
                clickByElement(buttonSendMessage);
                sendKeysByElement(inputMessage, message);
                clickByElement(buttonSend);
            } catch (WebDriverException e) {
                System.out.println("нельзя отправить сообщение");
            }
//        clickByElement(buttonSendMessage);
//        sendKeysByElement(inputMessage, message);
//        clickByElement(buttonSend);
        }

    }

    public void commentOnWall (String message) {
        clickByElement(buttonComment);
        sendKeysByElement(inputCommentPost, message);
//        clickByElement(buttonSendComment);
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public String getSPAM_PAGE_ADDRES() {
        return SPAM_PAGE_ADDRES;
    }

    public String getSPAM_PAGE_ADDRES1() {
        return SPAM_PAGE_ADDRES1;
    }

    public String getSPAM_PAGE_ADDRES2() {
        return SPAM_PAGE_ADDRES2;
    }

    public String getSPAM_PAGE_ADDRES3() {
        return SPAM_PAGE_ADDRES3;
    }

    public String getSPAM_PAGE_ADDRES4() {
        return SPAM_PAGE_ADDRES4;
    }

    public String getSPAM_PAGE_ADDRES5() {
        return SPAM_PAGE_ADDRES5;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getSPAM_MY_PAGE() {
        return SPAM_MY_PAGE;
    }


}
