(ns getaroom.core
  (:gen-class)
  (:require [getaroom.services.wit-client :as wit])
  (:require [getaroom.services.nexmo-client :as nexmo-client])
  (:require [getaroom.services.nexmo-server :as nexmo-server])
  )

(defn -main
  "Start the server"
  [message & args]
  ; Send the message to wit, let it be "response"
  (nexmo-server/start-server)
  ;(let [response (wit/submit-text message)]
  ;  (let [[outcome] (wit/get-outcomes response)]
  ;    (let [[building & others] (wit/get-buildings outcome)]
  ;      (clojure.pprint/pprint (nexmo-client/send-sms "15405975005" (str "I found you a room in: " building)))
  ;      )
  ;    ))
  )
