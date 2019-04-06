

var $ = jQuery.noConflict();

//Subscribe
function subscribeUser()
{
    var selection = document.getElementById("newsletter").elements[0].value;
    var email = document.getElementById("newsletter").elements[1].value;
    var name = document.getElementById("newsletter").elements[2].value;

    document.getElementById("newsletter-form-input").style.display = "none";
    document.getElementById("newsletter-form-error").style.display = "none";

    if(
        validateEmail(email) &&
        name && name.length && name.trim().length > 0
    ){
        sendSubscribeRequest({
            description: selection,
            email: email,
            name: name,
            source: "solid.isapanah.com",
            campaign: "site"
        })
    }else{
        document.getElementById("newsletter-form-input").style.display = "flex";
    }
}

function sendSubscribeRequest(prams)
{
    $.post( "https://subs.isapanah.com/newsletter/register", prams)
        .done(function( data ) {
            document.getElementById("newsletter").style.display = "none";
            $("#newsletter-container").after(
                '<br/><div class="alert alert-success"><strong>با تشکر، فصل انتخابی به ایمیل شما ارسال شد. لطفا فولدر spam را هم چک کنید.</strong></div>'
            )
        }).fail(function() {
            document.getElementById("newsletter-form-error").style.display = "flex";
        })
}

//Contact
function contact()
{
    var name = document.getElementById("contact").elements[0].value;
    var email = document.getElementById("contact").elements[1].value;
    var subject = document.getElementById("contact").elements[2].value;
    var message = document.getElementById("contact").elements[3].value;


    document.getElementById("contact-form-error").style.display = "none";
    document.getElementById("contact-form-input").style.display = "none";

    if(
        validateEmail(email) &&
        message && message.length && message.trim().length > 0
    ){
        sendNewMessage({
            name: name,
            email: email,
            subject: subject,
            message: message,
            source: "solid.isapanah.com"
        })
    }else{
        document.getElementById("contact-form-input").style.display = "flex";
    }
}


function sendNewMessage(prams)
{
    $.post( "https://subs.isapanah.com/contact/new", prams)
        .done(function( data ) {
            document.getElementById("contact").style.display = "none";
            $("#contact-container").after(
                '<br/><div class="alert alert-success"><strong>پیام شما با موفقیت دریافت شد. درصورت لزوم با شما تماس خواهیم گرفت.</strong></div>'
            )
        }).fail(function() {
            document.getElementById("contact-form-error").style.display = "flex";
        })
}




// Validate the email address in the form
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}