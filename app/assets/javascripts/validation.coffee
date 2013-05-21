###value =  "this is validation file"
alert value###
this.cofeeFunc = ->
  coffeeAns =  confirm "Ready for coffee?"
  ans = if coffeeAns then "Wooow U R Ready for Coffee :) " else "Ohh Not ready for Coffee :( "
  alert ans
###Another function to validate input of term ###
this.checkForTerm=(term) -> if term is ''
  alert("Term Required..!!!")
  false
else
  true
### Another function for testing purpose ###
this.myFunc = -> true
###another function###
this.anotherFunc = -> false

