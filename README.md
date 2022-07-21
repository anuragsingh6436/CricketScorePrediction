# CricketScorePrediction
#We have 3 options initially :-
  a)Predict Score
      so you have to enter Bowling type followed by ShotType and then ShotTiming
      and then outcome is generated using random number generator 
      output is like if we have 0 as an output we considered it as wicket and output will be 1 wicket otherwise ${output} runs.
      
  b)Commentary Flow
      so you have to enter Bowling type followed by ShotType and then ShotTiming
      and then outcome is generated using random number generator 
      and then we will predict commentary outcome depending on outcome 
      Like if we have 0 as an output the answer will be among ["It’s a wicket.", "Edged and taken."] and this is generated randomly.
      so the final outcome will be "${commentaryText} - ${outcome}runs"
      
  c)Super Over
      In this case we have fixed that indian team has batted first.
      now we will input indian team score from user and predict the score of australian team depending upon that.
      now we will enter shotType and ShotTiming from User and then basis on that we will predict the outcome and
      then we will print the score along with commentary
      and finally whenever the Australian team manages to score that amount of runs+1 we will end the and print the SUPEROVER FINAL OUTCOME..
      
      
      NOTE:I HAVE ADDED CHECKS TO INPUT CORRECT FORM OF DATA and in this case no ANDROID related components 
            is used so for writing test cases i have to restrucutre the whole code base(which will take again a lot of efforts)..
        
