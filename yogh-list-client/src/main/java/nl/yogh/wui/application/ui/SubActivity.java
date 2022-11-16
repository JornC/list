package nl.yogh.wui.application.ui;

public interface SubActivity {
  default void onStart() {
    // Default to no-op
  }
  
  default void onStop() {
    
  }
}
