(ns neuroverkko.core
    (:require [clojure.math.numeric-tower :as math]))

(def e 2.7182818284590452353602874713527)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def input
  [3 5])

(def weights
  [[[(rand) (rand)] [(rand) (rand)]] [[(rand) (rand)]]])

(defn divide-by-hours [input]
  (/ input 24))

(defn normalize [input]
  (map divide-by-hours input))

(def normalized-input (normalize input))

(defn vertice [input weight]
  (* input weight))

(defn calculate-weights [inputs weights]
  (map vertice inputs weights))

(defn sigmoid [value]
  (/ 1 (+ 1 (math/expt e (- value)))))

(defn step [input weights]
  (sigmoid (reduce + 0 (calculate-weights input weights))))

(defn forward [input weights]
  (if
    (empty? weights)
    input
    (let [rest-w (rest weights)
          first-w (first weights)]
      (forward (map (partial step input) first-w) rest-w))))

(forward normalized-input weights)
