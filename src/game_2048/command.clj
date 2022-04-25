(ns game-2048.command)

(defn get-command! []
  (try
    (let [command (read-line)
          direction ["left" "right" "up" "down"]]
      (if (not= 0 (count
                   (filter
                    #(= command %)
                    direction)))
        command
        (throw (RuntimeException. "Command Error"))))
  (catch Exception e
    (prn e))))
