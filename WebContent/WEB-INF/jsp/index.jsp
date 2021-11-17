<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Ajaxテスト用の画面 --%>
<%-- テキストボックスに数値を入力すると非同期通信によりインクリメントされた数値が返ってくる --%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		 <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	</head>

	<body>
		<script>
		$(function() {

			// ボタン押下時の処理
			$('#btn').on('click',function(){
				$.ajax({
					url: "AjaxServlet",						// 送信先のサーブレットクラスのURLパターン
					type: "GET",
					data: {num : $("#text1").val()}			// 送信先のサーブレットクラスにリクエストパラメータとして送信(多分)
				}).done(function (result) {
					// 通信成功時のコールバック
					alert(result);							// alertでインクリメントされた数値をポップアップに表示する
				}).fail(function (XMLHttpRequest, textStatus, errorThrown) {
					// 通信失敗時のコールバック
					alert("読み込み失敗");
				}).always(function (result) {
					// 常に実行する処理

				});
			});

		});

		</script>
		<h2>サンプルサーブレット2 Ajaxのテスト</h2>
		<input type="text" id="text1" />
		<button id="btn">Ajax</button>
	</body>

</html>