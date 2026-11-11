// BioPageProvider.java 
public class BioPageProvider implements PageProvider {
    @Override
    public String getHtml() {
        return "<!DOCTYPE html><html><head><meta charset='UTF-8'>"
             + "<title>Ödev</title></head>"
             + "<body style='font-family:Verdana; background-color:#f0f4f8;'>"
             + "<h1 style='color:#1a5276;'>Ad Soyad: Mehmet Ege Sarıgöl</h1>"
             + "<h2 style='color:#c0392b;'>Öğrenci No: 1250505035</h2>"
             + "<p style='font-family:Georgia; color:#2c3e50; font-size:18px;'>"
             + "Kırklareli Üniversitesi Yazılım Mühendisliği 2. sınıf öğrencisiyim. Yapay zeka ve ağ teknolojileri üzerine çalışmalar yapmaktayım. Aktif olarak kafe ve restoranlar için B2B hizmet veren Nex Menu adındaki SaaS platformumu yönetmekteyim.Yazılımın yanı sıra çocukluğumdan beri keman çalıyor ve aktif olarak voleybol ile ilgileniyorum.</p>"
             + "</body></html>";
    }
}