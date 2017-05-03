/******* SideBar *********/

document.getElementById("dashBoardTrigger").addEventListener("click", function () {
    openDashBoard();
});

function openDashBoard() {
    document.getElementById("myDashBoard").style.width = "320px";
    document.getElementById("myDashBoard").focus();
}

function closeDashBoard() {
    document.getElementById("myDashBoard").style.width = "0px";
}

$('.dashBoard').on({
  focusout: function () {
    $(this).data('submenuTimer', setTimeout(function () {
      closeDashBoard();
    }.bind(this), 0));
  },
  focusin: function () {
    clearTimeout($(this).data('submenuTimer'));
  },
  keydown: function (e) {
    if (e.which === 27) {
      closeDashBoard();
      e.preventDefault();
    }
  }
});

/******* Menu Dépliants DashBoard *********/

$("#echangeBox .gestionLien .categorieBtn:last-child").click(function () {
    if ($(".echangePlusDashBoard:visible").length != 0) {
        $(".echangePlusDashBoard").slideUp("normal", function () {
            $(this).parent().removeClass("open")
        });
        $(this).children().last().removeClass("ion-android-arrow-dropdown");
        $(this).children().last().addClass("ion-android-arrow-dropright");
    } else {
        $(".echangePlusDashBoard").slideDown("normal", function () {
            $(this).parent().addClass("open")
        });
        $(this).children().last().removeClass("ion-android-arrow-dropright");
        $(this).children().last().addClass("ion-android-arrow-dropdown");
    }
    return false;
});

$("#notificationBox .categorieBtn:last-child").click(function () {
    if ($(".notificationsPlus:visible").length != 0) {
        $(".notificationsPlus").slideUp("normal", function () {
            $(this).parent().removeClass("open")
        });
        $(this).children().last().removeClass("ion-android-arrow-dropdown");
        $(this).children().last().addClass("ion-android-arrow-dropright");
    } else {
        $(".notificationsPlus").slideDown("normal", function () {
            $(this).parent().addClass("open")
        });
        $(this).children().last().removeClass("ion-android-arrow-dropright");
        $(this).children().last().addClass("ion-android-arrow-dropdown");
    }
    return false;
});