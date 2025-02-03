package com.betagames.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.betagames.dto.OrdersDTO;
import com.betagames.dto.PayCardsDTO;
import com.betagames.model.Orders;
import com.betagames.model.PayCards;
import com.betagames.dto.EditorsDTO;
import com.betagames.model.Editors;

import com.betagames.dto.GamesDTO;
import com.betagames.model.Games;

public class Utilities {
  
  public static List<OrdersDTO> buildOrdersDTO(List<Orders> listOrders){
        return listOrders.stream()
                        .map(order -> new OrdersDTO(order.getId(), order.getTotalAmmount(),order.getOrderStatus(), order.getCreatedAt(), order.getUpdatedAt(), 
                                                    null, null, null)) //settati a null perchè mancano i buildDTO
                        .collect(Collectors.toList());
    }
    private final static String PATTERN_DATE = "dd/MM/yyyy";
	  public static Date convertStringToDate(String dataString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATE, Locale.ITALY);
		return formatter.parse(dataString);
	}

    public static EditorsDTO buildEditorsDTO(Editors e) {
        return new EditorsDTO(
                e.getId(),
                e.getName(),
                e.getWebsite());
    }// buildEditorsDTO

    public static List<EditorsDTO> buildEditorsDTO(List<Editors> e) {
        return e.stream()
                .map(ed -> new EditorsDTO(
                        ed.getId(),
                        ed.getName(),
                        ed.getWebsite()))
                .collect(Collectors.toList());
    }// buildEditorsDTO

    // public static ReviewsDTO buildReviewsDTO(Reviews r) {
    //     return new ReviewsDTO(
    //             r.getId(),
    //             r.getScore(),
    //             r.getDescription(),
    //             r.getCreatedAt(),
    //             buildUsersDTO(r.getUser()),
    //             buildGamesDTO(r.getGame()));
    // }// buildReviewsDTO

    // public static List<ReviewsDTO> buildReviewsDTO(List<Reviews> r) {
    //     return r.stream()
    //             .map(re -> new ReviewsDTO(
    //                     re.getId(),
    //                     re.getScore(),
    //                     re.getDescription(),
    //                     re.getCreatedAt(),
    //                     buildUsersDTO(re.getUser()),
    //                     buildGamesDTO(re.getGame())))
    //             .collect(Collectors.toList());
    // }// buildReviewsDTO

    // public static UsersDTO buildUsersDTO(Users u) {
    //     return new UsersDTO(
    //             u.getId(),
    //             u.getUsername(),
    //             u.getEmail(),
    //             u.getPwd(),
    //             buildReviewsDTO(u.getListReviews()),
    //             buildOrdersDTO(u.getListOrders()),
    //             buildPayCardsDTO(u.getListPayCards())
    //     );
    // }// buildUsersDTO

    // public static List<UsersDTO> buildUsersDTO(List<Users> u){
    //     return u.stream()
    //             .map(us -> new UsersDTO(
    //                 us.getId(),
    //                 us.getUsername(),
    //                 us.getEmail(),
    //                 us.getPwd(),
    //                 buildReviewsDTO(us.getListReviews()),
    //                 buildOrdersDTO(us.getListOrders()),
    //                 buildPayCardsDTO(us.getListPayCards()) 
    //             ))
    //             .collect(Collectors.toList());
    // }// buildUsersDTO
  
  // 	public static List<GamesDTO> buildAbbonamentoDTO(List<Games> games) {
	// 	return games.stream()
	// 			.map(a -> new GamesDTO(
    //                 a.getId(),
    //                 a.getName(),
    //                 a.getDate(),
    //                 a.getMinGameTime(),
    //                 a.getMaxGameTime(),
    //                 a.getMinPlayerNumber(),
    //                 a.getMaxPlayerNumber(),
    //                 a.getMinAge(),
    //                 a.getDescription(),
    //                 a.getStockQuantity(),
    //                 a.getPrice(),
    //                 a.getListAuthors()))
	// 			.collect(Collectors.toList());
	// }

    public static GamesDTO buildGamesDTO(Games g){
      return new GamesDTO(
                  g.getId(),
                  g.getName(),
                  g.getDate(),
                  g.getMinGameTime(),
                  g.getMaxGameTime(),
                  g.getMinPlayerNumber(),
                  g.getMaxPlayerNumber(),
                  g.getMinAge(),
                  g.getDescription(),
                  g.getStockQuantity(),
                  g.getPrice(),
                  buildEditorsDTO(g.getEditor()),
                  buildCategoryDTO(g.getListCategory()),
                  buildDetailsOrderDTO(g.getListDetailsOrder()),
                  buildDetailsCartDTO(g.getListDetailsCarts()),
                  buildReviewsDTO(g.getListReviews()),
                  buildAuthorsDTO(g.getListAuthors())
       );
    }//buildGamesDTO

    public static List<GamesDTO> buildGamesDTO(List<Games> g){
      return g.stream()
              .map(gs -> new GamesDTO(
                gs.getId(),
                gs.getName(),
                gs.getDate(),
                gs.getMinGameTime(),
                gs.getMaxGameTime(),
                gs.getMinPlayerNumber(),
                gs.getMaxPlayerNumber(),
                gs.getMinAge(),
                gs.getDescription(),
                gs.getStockQuantity(),
                gs.getPrice(),
                buildEditorsDTO(gs.getEditor()),
                buildCategoryDTO(gs.getListCategory()),
                buildDetailsOrderDTO(gs.getListDetailsOrder()),
                buildDetailsCartDTO(gs.getListDetailsCarts()),
                buildReviewsDTO(gs.getListReviews()),
                buildAuthorsDTO(gs.getListAuthors())
                ))
                .collect(Collectors.toList());
    }//List buildGamesDTO

    public static PayCardsDTO buildPayCardsDTO(PayCards p){
      return new PayCardsDTO(
                  p.getId(),
                  p.getCardNumber(),
                  p.getCardHolderName(),
                  p.getExpirationDate(),
                  p.getCvv(),
                  p.getBillingAddress(),
                  p.getCreatedAt(),
                  p.getUpdatedAt(),
                  buildUsersDTO(p.getUser()),
                  buildOrdersDTO(p.getOrder())
      );
    }//PayCardsDTO

    public static List<PayCardsDTO> buildPayCardsDTO(List<PayCards> p){
      return p.stream()
              .map(ps -> new PayCardsDTO(
                ps.getId(),
                ps.getCardNumber(),
                ps.getCardHolderName(),
                ps.getExpirationDate(),
                ps.getCvv(),
                ps.getBillingAddress(),
                ps.getCreatedAt(),
                ps.getUpdatedAt(),
                buildUsersDTO(ps.getUser()),
                buildOrdersDTO(ps.getOrder())
              ))
              .collect(Collectors.toList());
    }//List buildPayCardsDTO



    
}// class
