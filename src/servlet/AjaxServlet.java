package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ajax(非同期通信)テスト用サーブレットクラス
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * index.jspからリクエストパラメータが送られてくる(テキストボックスに入力した数値)<br>
	 * その数値をインクリメントしてindex.jspに返す
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Ajaxで渡されたテキストボックスの値を変数に格納
		String num = request.getParameter("num");

		// カウントアップ処理(1度数値に変換してインクリメントした後に文字列に戻す)
		// (本来はここでDB接続するなどの処理を記述していく)
		num = String.valueOf(Integer.parseInt(num) + 1);

		// 返却値に設定
		PrintWriter out = response.getWriter();
		out.print(num);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POSTで実行する場合はこちらに記述
	}

}
