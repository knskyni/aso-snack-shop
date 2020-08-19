function updateCart(itemId, itemCount) {
    $.ajax({
        url:'/sweeter/cart/add',
        type:'GET',
        data:{
            'id': itemId,
            'count': itemCount
        }
    })
    .done((data) => {
        location.reload();
    })
    .fail((jqXHR, textStatus, errorThrown) => {
        alert('更新に失敗しました。');
    });
}

function updateFavorite(itemId) {
    $.ajax({
        url:'/sweeter/favorite/add',
        type:'GET',
        data:{
            'id': itemId
        }
    })
    .done((data) => {
    	alert('お気に入り追加しました。');
		location.reload();
    })
    .fail((jqXHR, textStatus, errorThrown) => {
        alert('更新に失敗しました。');
    });
}