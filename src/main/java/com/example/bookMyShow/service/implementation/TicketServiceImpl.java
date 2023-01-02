package com.example.bookMyShow.service.implementation;

import com.example.bookMyShow.converter.TicketConverter;
import com.example.bookMyShow.dto.requestDto.BookTicketRequestDto;
import com.example.bookMyShow.dto.responseDto.TicketResponseDto;
import com.example.bookMyShow.model.Show;
import com.example.bookMyShow.model.ShowSeats;
import com.example.bookMyShow.model.Ticket;
import com.example.bookMyShow.model.User;
import com.example.bookMyShow.repository.ShowRepository;
import com.example.bookMyShow.repository.TicketRepository;
import com.example.bookMyShow.repository.UserRepository;
import com.example.bookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        User user=userRepository.findById(bookTicketRequestDto.getUserId()).get();
        Show show=showRepository.findById(bookTicketRequestDto.getShowId()).get();
        Set<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();
        List<ShowSeats> showSeats=show.getShowSeats();
        List<ShowSeats> bookedSeats=new ArrayList<>();
        for(ShowSeats seats:showSeats){
            if(!seats.isBooked() && seats.getSeattype().equals(bookTicketRequestDto.getSeatType()) && requestedSeats.contains(seats.getSeat_no())){
                bookedSeats.add(seats);
            }
        }
        int amount=0;
        if(bookedSeats.size()!=requestedSeats.size()) throw new Error("All seats are not available");
        Ticket ticket=Ticket.builder().user(user).show(show).showSeats(bookedSeats).build();
        for (ShowSeats seats:bookedSeats){
            seats.setBooked(true);
            seats.setBookedDate(new Date());
            seats.setTicket(ticket);
            amount+=seats.getRate();
        }
        ticket.setBookedOn(new Date());
        ticket.setAllottedSeat(listOfSeatsToString(bookedSeats));
        ticket.setAmount(amount);
        show.getTickets().add(ticket);
        user.getTickets().add(ticket);
        ticket=ticketRepository.save(ticket);
        return TicketConverter.entityToDto(ticket);
    }

    private String listOfSeatsToString(List<ShowSeats> bookedSeats) {
        String s="";
        for(ShowSeats seats:bookedSeats){
            s=s+seats.getSeat_no()+" ";
        }
        return s;
    }

    @Override
    public TicketResponseDto getTicket(int id) {
        Ticket ticket=ticketRepository.findById(id).get();
        return TicketConverter.entityToDto(ticket);
    }
}
