(ns economics-games.prisoners-dilemma)


(def TOTAL_ROUNDS 2)

(def game (atom {}))

(defn player-decision [player decision]
  (if (< (count @game) TOTAL_ROUNDS)
    (swap! game assoc player decision)
    @game))

(defn cooperate [player]
  (player-decision player "cooperate"))
