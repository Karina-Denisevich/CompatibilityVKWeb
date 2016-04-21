function createInfo() {
    var ids = [];
    var sexes = [];
    var bDates = [];
    var artists = [];

    VK.init(function () {
            getUserInfoVK();
        }
    );

    function getUserInfoVK() {
        VK.api('users.get', {uids: '50181012, idgoaway1, nordicwarrior', fields: 'uid, sex, bdate'}
            , function f(r) {

                if (r.response) {

                    for (var i = 0; i < r.response.length; i++) {

                        ids.push(r.response[i].uid);
                        sexes.push(r.response[i].sex);
                        bDates.push(r.response[i].bdate);
                    }


                    $('#clientForm\\:vkId').val(ids);
                    $('#clientForm\\:vkBdate').val(bDates);
                    $('#clientForm\\:vkSex').val(sexes);
                    $('#clientForm\\:link1').click();
                    $('#clientForm\\:link2').click();
                    $('#clientForm\\:link3').click();

                    setTimeout(function(){$('#clientForm\\:link5').click()}, 700);


                    //);
                    //$('#clientForm\\:link2').click(function(){
                    //        $('#clientForm\\:vkSex').val(sexes);
                    //    return false;
                    //}
                    //
                    //);
                    //$('#clientForm\\:link3').click(function(){
                    //    $('#clientForm\\:vkBdate').val(bDates);
                    //    return false;
                    //});
                    // getUserAudio(0);

                    //
                   // setTimeout(callAfterMain, 2000);
                }
            });
    }


    //
    //function getUserAudio(i) {
    //
    //    VK.api('audio.get', {owner_id: ids[i], count: '10'}, function (audio) {
    //        if (audio.response) {
    //            for (var j = 1; j < audio.response.length; j++) {
    //                artists.push(audio.response[j].artist);
    //            }
    //        } else {
    //            artists.push(null);
    //        }
    //        $('#clientForm\\:vkAudio').val(artists);
    //        $('#clientForm\\:link4').click();
    //        artists = [];
    //        i++;
    //        if (i < ids.length) {
    //            getUserAudio(i);
    //        }else{
    //            $('#clientForm\\:link5').click();
    //            setTimeout(callAfterMain, 2000);
    //        }
    //    });
    //}
    //
    function callAfterMain(){
        $('#clientForm\\:link6').click();
        //$('#clientForm\\:link7').click();
    }

}
