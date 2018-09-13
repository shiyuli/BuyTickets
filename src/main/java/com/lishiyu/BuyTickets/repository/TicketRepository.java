package com.lishiyu.BuyTickets.repository;

import com.lishiyu.BuyTickets.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    public List<Ticket> findByStation(String station);
    public List<Ticket> findById(Integer id);
}
