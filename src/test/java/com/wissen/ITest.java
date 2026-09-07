package com.wissen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wissen.interfaces.InterfaceDemo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ITest {

    @Mock
    InterfaceDemo mockI;   // Mockito injects the mock automatically — no implementation class needed

    // 1. Test for interface method with no access to an implementation class
    @Test
    void testAbcCanBeCalledOnMock() {
        mockI.abc();
        verify(mockI).abc();
    }

    // 2. Test for a method that doesn't return anything (void)
    @Test
    void testVoidMethodDoesNothingByDefault() {
        doNothing().when(mockI).abc();

        mockI.abc();

        verify(mockI).abc();
    }

    @Test
    void testVoidMethodThrowsException() {
        doThrow(new RuntimeException("Simulated failure")).when(mockI).abc();

        assertThrows(RuntimeException.class, () -> mockI.abc());
    }

    // 3. Test for the number of times a method is called
    @Test
    void testAbcCalledExactlyTwice() {
        mockI.abc();
        mockI.abc();
        //mockI.abc();
        
        verify(mockI, times(2)).abc();
    }

    @Test
    void testAbcNeverCalled() {
        verify(mockI, never()).abc();
    }

    @Test
    void testAbcCalledAtLeastOnce() {
        mockI.abc();

        verify(mockI, atLeastOnce()).abc();
    }
}
