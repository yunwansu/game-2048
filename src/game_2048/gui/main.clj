(ns game-2048.gui.main
  (:import [javax.swing JFrame JLabel JButton]
           [java.awt.event WindowListener]))

(defn draw []
  (let [frame (JFrame. "Fund manager")
        label (JLabel. "Exit on close")
        content-pane (.getContentPane frame)]
    (doto frame
      (.add label)
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.addWindowListener
       (proxy [WindowListener] []
         (windowClosing [evt]
           (println "Whoop"))))
      (.setVisible true))
    (.add content-pane label)
    (.pack frame)))
    

