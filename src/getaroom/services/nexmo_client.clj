(ns getaroom.services.nexmo-client
  (:gen-class)
  (:require
    [org.httpkit.client :as http]
    [cheshire.core :as json])
  (:use carica.core)
  )

(defn send-sms
  "Sends a text message"
  [to body]

  (let [options {:query-params
                 {:api_key    (config :nexmo :api-key)
                  :api_secret (config :nexmo :api-secret)
                  :from       (config :nexmo :from-number)
                  :to         to
                  :text       body}
                 }
        {:keys [status error body]} @(http/post "https://rest.nexmo.com/sms/json" options)]
    (if error
      (println "Failed, exception is " error)
      (println "Async HTTP POST: " status))

    (if (== 200 status)
      (json/parse-string body)
      status
      )
    )
  )

(defn send-msg
  "Sends a text message using the SMS DTO"
  [sms]
  true
  )