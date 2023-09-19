import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class LodgingContent extends ContentArea {
	@Override
	public void initialize() {
		
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        // Load a web page
        webEngine.load("https://www.cruisemapper.com/cruise-search"); // add in lodging site
        
		content = new VBox(webView);
	}
}
