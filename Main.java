<html>
<head>
<style>
body{
}
.text1{
color:red;
text-decoration: overline;
}
.text2{
color:#71ffb0;
text-decoration: line-through;
}
.text3{
color: rgb(70, 98, 120);
text-decoration: underline;
}
.text4{
color:rgba(0,0,0,.4);
text-decoration: underline-overline;
}
.p1{
font-family: "Times New Roman", Times,serif;
}
.p2{
font-family: Arial,Helvetica, sans-serif;
}
  .p3{
    font-size:10px
  }
  .error-message{
    color: red;
    font-weight: bold;
    display: none;
  }
  h1:hover{
  color:red;
  background-color:yellow;
  text-shadow:2px 2px 5px black;
  }
</style>
</head>
<body bgcolor="lightblue">
<h1><center><marquee direction="right" scrollamount="25">Bank App</marquee></center></h1><br>
<center><img src="download (1).jfif"</center>
<p class="text1">Welcome to the Bank App</p>
  <center>
  <form>
    <Fieldset>
    <lable>Name:</lable>
    <input type="text" id="name" placeholder="Enter your Full Name"><br><br>
    <lable>Card No:</lable>
    <input type="number" id="card-no"  placeholder="Enter your Card Number"><br><br>
    <lable>Transaction Amount:</lable>
    <input type="number" id="amount"  placeholder="Enter your transaction amount"><br><br>
    <p class="error-message" id="insufficient-balance"></p>
    <p class="error-message" id="amount-zero"></p>
  </form>
    <input type="submit" value="Debit" id="debit" style="background-color:red
    ;color:white; width:95px; height:50px; border-color:white; padding:5px" >
    <input type="submit" value="Credit" id="credit" style="background-color:red
      ;color:white; width:95px; height:50px; border-color:white; padding:5px" >
    <p class="text3" id="balance">Account Balance : 000</p>
    </center>
  <p class="text2">Thank you</p>
  <p class="p1">Thank you for choosing us and for the opputunity to serve you. </p>
  <p class="p2">We are currently the biggest bank company.</p>
  <p class="p3"><mark>JS is added!</mark></p>
  <hr color="black">
  </Fieldset>
<script>
// Get references to the elements
var balanceEl = document.getElementById('balance');
var amountEl = document.getElementById('amount');
var debitBtn = document.getElementById('debit');
var creditBtn = document.getElementById('credit');
var insufficientBalanceMessage = document.getElementById('insufficient-balance');
var amountZeroMessage = document.getElementById('amount-zero');
// Initial balance
var balance = 0;
// Update balance display
function updateBalance() {
  balanceEl.innerText = "Account Balance: " + balance;
}
// Make sure the script runs after the HTML is loaded
window.onload = function() {
  // Get references to the elements (again, in case they weren't ready before)
  balanceEl = document.getElementById('balance');
  amountEl = document.getElementById('amount');
  debitBtn = document.getElementById('debit');
  creditBtn = document.getElementById('credit');
  insufficientBalanceMessage = document.getElementById('insufficient-balance');
  amountZeroMessage = document.getElementById('amount-zero');
  // Initial prompt message
  insufficientBalanceMessage.innerText = "Please Enter an amount";
  insufficientBalanceMessage.style.display = 'block'; 
  // Event listener for debit button
  debitBtn.addEventListener('click', function(event) {
    event.preventDefault(); // Prevent form submission
    var amount = parseFloat(amountEl.value);
    if (!isNaN(amount)) {
      if (amount <= balance) {
        balance -= amount;
        updateBalance();
        amountEl.value = ""; // Clear input field
        insufficientBalanceMessage.style.display = 'none';
        amountZeroMessage.style.display = 'none';
      } else {
        insufficientBalanceMessage.innerText = "Your bank account does not have sufficient balance. Please enter a valid amount.";
        insufficientBalanceMessage.style.display = 'block';
        amountZeroMessage.style.display = 'none';
      }
    } else {
      insufficientBalanceMessage.innerText = "Please enter a valid amount.";
      insufficientBalanceMessage.style.display = 'block';
      amountZeroMessage.style.display = 'none';
    }
  });
  // Event listener for credit button
  creditBtn.addEventListener('click', function(event) {
    event.preventDefault(); // Prevent form submission
    var amount = parseFloat(amountEl.value);
    if (!isNaN(amount)) {
      if (amount > 0) {
        balance += amount;
        updateBalance();
        amountEl.value = ""; // Clear input field
        insufficientBalanceMessage.style.display = 'none';
        amountZeroMessage.style.display = 'none';
      } else {
        amountZeroMessage.innerText = "Please enter an amount greater than 0.";
        amountZeroMessage.style.display = 'block';
        insufficientBalanceMessage.style.display = 'none';
      }
    } else {
      amountZeroMessage.innerText = "Please enter a valid amount.";
      amountZeroMessage.style.display = 'block';
      insufficientBalanceMessage.style.display = 'none';
    }
  });
  // Initial balance display
  updateBalance();
};
</script>
<br>
  <audio controls autoplay>   
  <source src="Welcome to the bank .mp3" type="audio/mp3">  
    Your browser does not support the audio element.   </audio>
</body>
</html>