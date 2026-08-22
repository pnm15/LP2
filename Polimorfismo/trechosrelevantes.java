public abstract class Plugin implements Module {
	protected void startUp() throws Exception {
  }

	protected void shutDown() throws Exception {
  }
}
public class HunterPlugin extends Plugin {
    @Override
    protected void startUp() {
        overlayManager.add(overlay);
        overlay.updateConfig();
    }
    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
    }
}
