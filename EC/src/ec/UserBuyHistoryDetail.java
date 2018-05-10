package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BuyDataBeans;
import beans.BuyDetailDataBeans;
import dao.BuyDAO;

/**
 * 購入履歴画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/UserBuyHistoryDetail")
public class UserBuyHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String buyid = request.getParameter("buy_id");
		int buyId = Integer.parseInt(buyid);
		BuyDataBeans buyHistry = new BuyDataBeans();

		try {
			buyHistry = BuyDAO.getBuyDataBeansByBuyId(buyId);

			List<BuyDetailDataBeans> userBuyList = BuyDAO.getBuyDetailDataBeansByBuyId(buyId);
			request.setAttribute("userBuyList", userBuyList);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		Date buyDate = buyHistry.getBuyDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		sdf.applyPattern("yyyy年MM月dd日 hh時mm分");
		String Date = sdf.format(buyDate);

		request.setAttribute("buyDate", Date);



		request.setAttribute("buyHistry", buyHistry);


		request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_DETAIL_PAGE).forward(request, response);

	}
}
