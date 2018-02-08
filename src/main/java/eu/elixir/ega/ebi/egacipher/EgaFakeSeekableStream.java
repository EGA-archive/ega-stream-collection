/*
 * Copyright 2016 ELIXIR EGA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.elixir.ega.ebi.egacipher;

import htsjdk.samtools.seekablestream.SeekableStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author asenf
 */
public class EgaFakeSeekableStream extends SeekableStream {

    private final InputStream in;
    private long position;
    private long contentLength = -1;

    public EgaFakeSeekableStream(InputStream in) {
        this.in = in;
        this.position = 0;
    }

    public EgaFakeSeekableStream(InputStream in, long contentLength) {
        this.in = in;
        this.position = 0;
        this.contentLength = contentLength;
    }

    @Override
    public long length() {
        return contentLength;
    }

    @Override
    public long position() throws IOException {
        return this.position;
    }

    @Override
    public void seek(long l) throws IOException {
        if (l >= this.position) {
            for (long li = 0; li < (l - this.position); li++) {
                this.in.read();
            }
            //this.in.skip(l - this.position);
            this.position = l;
        } else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        this.position += i1;
        return in.read(bytes, i, i1);
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public boolean eof() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int read() throws IOException {
        this.position += 1;
        return in.read();
    }

}
