package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Booking;
import edu.icet.ecom.entity.BookingEntity;
import edu.icet.ecom.repository.BookingRepository;
import edu.icet.ecom.repository.VehicleRepository;
import edu.icet.ecom.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;

    @Override
    public Booking createBooking(Booking booking) {
        BookingEntity entity = modelMapper.map(booking, BookingEntity.class);
        entity = bookingRepository.save(entity);
        return modelMapper.map(entity, Booking.class);
    }

    @Override
    public Booking getBookingById(Long id) {
        BookingEntity entity = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return modelMapper.map(entity, Booking.class);
    }

    @Override
    public List<Booking> getAllBookings() {
        List<BookingEntity> entities = bookingRepository.findAll();
        return entities.stream().map(entity -> modelMapper.map(entity, Booking.class)).collect(Collectors.toList());
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        BookingEntity entity = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        modelMapper.map(booking, entity);
        entity = bookingRepository.save(entity);
        return modelMapper.map(entity, Booking.class);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
