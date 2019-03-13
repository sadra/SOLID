var $ = jQuery.noConflict();

$(document).ready(function($) {
    "use strict";

    /*----------------------------------------------------*/
    /*  Parallax Scrolling
    /*----------------------------------------------------*/

    $(window).on('load', function() {
		$('#preloader').fadeOut('slow',function(){$(this).remove();});
    });

    function parallaxInit() {
        $("#top-banner").parallax("50%", 0.5);
        $("#count-success").parallax("50%", 0.5);
        $("#subscribe").parallax("50%", 0.5);
        $("#buy-now").parallax("50%", 0.5);
    }
    parallaxInit();

    /*----------------------------------------------------*/
    /*  PrettyPhoto
    /*----------------------------------------------------*/

    $("a[rel^='prettyPhoto']").prettyPhoto({
        social_tools: false
    });

    /*----------------------------------------------------*/
    /*  owl carousel
    /*----------------------------------------------------*/

    $('.preview-carousel').owlCarousel({
        responsiveClass: true,
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            769: {
                items: 3
            }
        },
        dots: false,
        nav: true,
        navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]
    });

    $('.book-carousel').owlCarousel({
        responsiveClass: true,
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            769: {
                items: 3
            }
        },
        dots: false,
        nav: true,
        navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]
    });

    /*----------------------------------------------------*/
    /*  sticky header
    /*----------------------------------------------------*/

    $(window).scroll(function() {

        if ($(window).scrollTop() > 700) {

            $('.main-nav').addClass('navbar-fixed-top animated fadeInDown');
        } else {

            $('.main-nav').removeClass('navbar-fixed-top animated fadeInDown');

        }
    });

    /*----------------------------------------------------*/
    /*  Page Scroll
    /*----------------------------------------------------*/

    $(function() {
        $('a.page-scroll').on('click', function(event) {
            var $anchor = $(this);
            $('html, body').stop().animate({
                scrollTop: $($anchor.attr('href')).offset().top
            }, 1000, 'easeInOutExpo');
            event.preventDefault();
        });
    });


    /*----------------------------------------------------*/
    /*  Timer 
    /*----------------------------------------------------*/

    $('#count-success').on('inview', function(event, visible, visiblePartX, visiblePartY) {
        if (visible) {
            $(this).find('.timer').each(function() {
                var $this = $(this);
                $({
                    Counter: 0
                }).animate({
                    Counter: $this.text()
                }, {
                    duration: 2000,
                    easing: 'swing',
                    step: function() {
                        $this.text(Math.ceil(this.Counter));
                    }
                });
            });
            $(this).off('inview');
        }
    });

    /*----------------------------------------------------*/
    /*  Wow Js
    /*----------------------------------------------------*/

    new WOW().init();

    /*----------------------------------------------------*/
    /*	Back Top Link
    /*----------------------------------------------------*/

    var offset = 200;
    var duration = 1000;
    $(window).scroll(function() {
        if ($(this).scrollTop() > offset) {
            $('.back-to-top').fadeIn(400);
        } else {
            $('.back-to-top').fadeOut(400);
        }
    });
    $('.back-to-top').on("click", function(event) {
        event.preventDefault();
        $('html, body').animate({
            scrollTop: 0
        }, 1000);
        return false;
    });

    /*----------------------------------------------------*/
    /*  SmoothScroll
    /*----------------------------------------------------*/

    $('html').smoothScroll(1000);

    /*----------------------------------------------------*/
    /*  Contact Form
    /*----------------------------------------------------*/
    //
    // $("#contact").submit(function(e) {
    //     e.preventDefault();
    //     var name = $("#name").val();
    //     var email = $("#email").val();
    //     var subject = $("#subject").val();
    //     var message = $("#message").val();
    //     var dataString = 'name=' + name + '&email=' + email + '&subject=' + subject + '&message=' + message;
    //
    //     function isValidEmail(emailAddress) {
    //         var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
    //         return pattern.test(emailAddress);
    //     };
    //
    //     if (isValidEmail(email) && (message.length > 1) && (name.length > 1)) {
    //         $.ajax({
    //             type: "GET",
    //             url: "https://subs.isapanah.com/",
    //             data: dataString,
    //             success: function() {
    //                 $('.success').fadeIn(1000);
    //                 $('.error').fadeOut(500);
    //             }
    //         });
    //     } else {
    //         $('.error').fadeIn(1000);
    //         $('.success').fadeOut(500);
    //     }
    //
    //     return false;
    // });
    /*----------------------------------------------------*/
    /*  Subscribe
    /*----------------------------------------------------*/
    // ajaxMailChimpForm($("#newsletter"), $("#subscribe-result"));
    // // Turn the given MailChimp form into an ajax version of it.
    // function ajaxMailChimpForm($form, $resultElement) {
    //     $form.submit(function(e) {
    //         e.preventDefault();
    //         if (!isValidEmail($form)) {
    //             var error = "A valid email address must be provided.";
    //             $resultElement.html(error);
    //             $resultElement.css("color", "red");
    //         } else {
    //             $resultElement.css("color", "black");
    //             $resultElement.html("Subscribing...");
    //             submitSubscribeForm($form, $resultElement);
    //         }
    //     });
    // }
    // Validate the email address in the form
    // function isValidEmail($form) {
    //     // If email is empty, show error message.
    //     var email = $form.find("input[type='email']").val();
    //     if (!email || !email.length) {
    //         return false;
    //     } else if (email.indexOf("@") == -1) {
    //         return false;
    //     }
    //     return true;
    // }

    // function submitSubscribeForm($form, $resultElement) {
    //     $.ajax({
    //         type: "GET",
    //         url: $form.attr("action"),
    //         data: $form.serialize(),
    //         cache: false,
    //         dataType: "jsonp",
    //         jsonp: "c", // trigger MailChimp to return a JSONP response
    //         contentType: "application/json; charset=utf-8",
    //         error: function(error) {
    //
    //         },
    //         success: function(data) {
    //             if (data.result != "success") {
    //                 var message = data.msg || "Sorry. Unable to subscribe. Please try again later.";
    //                 $resultElement.css("color", "red");
    //                 if (data.msg && data.msg.indexOf("already subscribed") >= 0) {
    //                     message = "You're already subscribed. Thank you.";
    //                     $resultElement.css("color", "black");
    //                 }
    //                 $resultElement.html(message);
    //             } else {
    //                 $resultElement.css("color", "black");
    //                 $resultElement.html("Thank you!<br>You must confirm the subscription in your inbox.");
    //             }
    //         }
    //     });
    // }
});