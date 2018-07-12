(ns economics-games.prisoners-dilemma-test
  (:require  [clojure.test :refer :all]
             [economics-games.prisoners-dilemma :as pd]))

(defn fixture [f]
  (reset! pd/game {})
  (f))

(use-fixtures :each fixture)

(deftest player-decision-test
  (testing "should update game with player and decision"
    (is (= {:player1 "cooperate"} (pd/player-decision :player1 "cooperate")))
    (is (= {:player1 "cooperate" :player2 "cooperate"} (pd/player-decision :player2 "cooperate") ))))
(deftest this-sucks-test
  (testing "should not allow more decisions than TOTAL_ROUNDS"
    (is (= 1  (count (pd/player-decision :player3 "cooperate"))))
    (is (= 2  (count (pd/player-decision :player4 "cooperate"))))
    (is (= 2  (count (pd/player-decision :player5 "cooperate"))))))

