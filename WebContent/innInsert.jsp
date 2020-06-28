<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="_head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Register New Hotel</title>
</head>
<body>

	<br>
	<br>

	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">
				登録する宿の情報を入力してください。<br>
				<br>
				<form action="/nhk/HotelInsertServlet" enctype="multipart/form-data"
					method="post">
					<div class="form-group">
						<label for="innName">名前</label> <input type="text" name="name"
							class="form-control" id="innName" placeholder="名前"><br>
					</div>
					<div class="form-group">
						<label for="innIntro">紹介文</label> <input type="text" name="intro"
							class="form-control" id="innIntro" placeholder="紹介文">
					</div>
					<div class="form-group">
						<label for="innAddresso">住所</label> <input type="text"
							name="address" class="form-control" id="innAddress"
							placeholder="住所">
					</div>
					<div class="form-group">
						<label for="innCheckin">チェックイン時間</label> <input type="text"
							name="checkin" class="form-control" id="innCheckin"
							placeholder="10:00">
					</div>
					<div class="form-group">
						<label for="innheckout">チェックアウト時間</label> <input type="text"
							name="checkout" class="form-control" id="innCheckout"
							placeholder="12:00">
					</div>
					<div class="form-group">
						<label for="innTel">tel</label> <input type="text" name="tel"
							class="form-control" id="innTel" placeholder="電話番号">
					</div>

					<div class="custom-file">
						<label for="file">画像のアップロード</label>
						<div id="file" class="input-group">
							<div class="custom-file">
								<input type="file" id="cutomfile" class="custom-file-input"
									name="fileUpload" /> <label class="custom-file-label"
									for="customfile" data-browse="参照">ファイル選択...</label>
							</div>
							<div class="input-group-append">
								<button type="button" class="btn btn-outline-secondary reset">取消</button>
							</div>
						</div>
					</div>

					<button type="submit" class="btn btn-primary mt-4 ml-2">確認画面へ</button>
					<input type="hidden" name="action" value="input">
				</form>

				<br> <a href="/nhk/adminMenu.jsp">メニューに戻る</a><br>
				<br>
				<br>


			</div>
		</div>
	</div>



	<%@ include file="_script.jsp"%>
</body>

<script>
	$('.custom-file-input').on('change', handleFileSelect);
	function handleFileSelect(evt) {
		$('#preview').remove();// 繰り返し実行時の処理
		$(this).parents('.input-group').after('<div id="preview"></div>');
		var files = evt.target.files;
		for (var i = 0, f; f = files[i]; i++) {
			var reader = new FileReader();
			reader.onload = (function(theFile) {
				return function(e) {
					if (theFile.type.match('image.*')) {
						var $html = [
								'<div class="d-inline-block mr-1 mt-1"><img class="img-thumbnail" src="',
								e.target.result,
								'" title="',
								escape(theFile.name),
								'" style="height:100px;" /><div class="small text-muted text-center">',
								escape(theFile.name), '</div></div>' ].join('');// 画像では画像のプレビューとファイル名の表示
					} else {
						var $html = [
								'<div class="d-inline-block mr-1"><span class="small">',
								escape(theFile.name), '</span></div>' ]
								.join('');//画像以外はファイル名のみの表示
					}
					$('#preview').append($html);
				};
			})(f);
			reader.readAsDataURL(f);
		}
		$(this).next('.custom-file-label').html('ファイルを選択しました');
	}
	//ファイルの取消
	$('.reset').click(
			function() {
				$(this).parent().prev().children('.custom-file-label').html(
						'ファイル選択...');
				$('#preview').remove();
				$('.custom-file-input').val('');
			})
</script>
</html>