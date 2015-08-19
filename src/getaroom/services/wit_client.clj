(ns getaroom.services.wit-client
  (:gen-class)
  (:require
    [org.httpkit.client :as http]
    [cheshire.core :as json])
  (:use carica.core)
  )

(defn submit-text
  "Sends a message to wit and returns its json response body"
  [message]
  (let [options {:query-params
                 {
                  :q            message
                  :access_token (config :wit :access-token)
                  :version      (config :wit :version)
                  }
                 }
        {:keys [status error body]} @(http/post "https://api.wit.ai/message" options)]
    (if error
      (println "Failed, exception is " error)
      (println "Async HTTP POST: " status))

    (if (== 200 status)
      (json/parse-string body)
      status)
    )
  )

(defn get-outcomes
  "Get outcomes from a wit json response body"
  [response]
  (let [[& data] (last response)]
    (let [outcomes (last data)]
      outcomes
      )
    )
  )

(defn get-buildings
  "Gets an array of relevant building names."
  [outcome]
  (let [ents (get outcome "entities")]
    (let [buildings (get ents "building")]
      ; If there aren't buildings, then return false. This probably should throw an exception or something.
      (if (nil? buildings)
        false
        ; Transform the syntax {"value" "MCB"} to just ("MCB")
        (mapcat (fn [x] [(get x "value")]) buildings)
        ))
    )
  )