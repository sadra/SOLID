<?php
// Email Submit
// Note: filter_var() requires PHP >= 5.2.0
if ( isset($_POST['email']) && isset($_POST['name']) && isset($_POST['subject']) && isset($_POST['message']) && filter_var($_POST['email'], FILTER_VALIDATE_EMAIL) ) {
 
  // detect & prevent header injections
  $test = "/(content-type|bcc:|cc:|to:)/i";
  foreach ( $_POST as $key => $val ) {
    if ( preg_match( $test, $val ) ) {
      exit;
    }
  }
  
  //
mail( "demo@demo-email.com", $_POST['subject'], $_POST['message'], "From:" . $_POST['email']);
  //			^
  //  Replace with your email 
}
?>